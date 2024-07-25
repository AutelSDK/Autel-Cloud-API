package com.autel.service.control.service.impl;

import com.autel.api.control.AbstractControlService;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.autoconfiguration.MqttPropertyConfiguration;
import com.autel.great.mqtt.constant.TopicConst;
import com.autel.great.mqtt.enums.device.DockModeCodeEnum;
import com.autel.great.mqtt.property.DrcModeMqttBroker;
import com.autel.great.mqtt.core.EventsReceiver;
import com.autel.great.mqtt.constant.MapKeyConst;
import com.autel.great.mqtt.model.control.DrcModeEnterRequest;
import com.autel.great.mqtt.model.device.OsdDockDrone;
import com.autel.great.mqtt.model.wayline.FlighttaskProgress;
import com.autel.great.mqtt.core.SDKManager;
import com.autel.great.mqtt.handle.services.ServicesReplyData;
import com.autel.great.mqtt.handle.services.TopicServicesResponse;
import com.autel.great.redis.RedisConst;
import com.autel.great.redis.RedisOpsUtils;
import com.autel.great.websocket.service.IWebSocketMessageService;
import com.autel.service.control.model.dto.JwtAclDTO;
import com.autel.service.control.model.enums.DroneAuthorityEnum;
import com.autel.service.control.model.enums.MqttAclAccessEnum;
import com.autel.service.control.model.param.DrcConnectParam;
import com.autel.service.control.model.param.DrcModeParam;
import com.autel.service.control.service.IControlService;
import com.autel.service.control.service.IDrcService;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.service.IDeviceRedisService;
import com.autel.service.manage.service.IDeviceService;
import com.autel.service.wayline.model.enums.WaylineJobStatusEnum;
import com.autel.service.wayline.model.enums.WaylineTaskStatusEnum;
import com.autel.service.wayline.model.param.UpdateJobParam;
import com.autel.service.wayline.service.IFlightTaskService;
import com.autel.service.wayline.service.IWaylineJobService;
import com.autel.service.wayline.service.IWaylineRedisService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class DrcServiceImpl implements IDrcService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IWaylineJobService waylineJobService;

    @Autowired
    private IFlightTaskService flighttaskService;

    @Autowired
    private IDeviceService deviceService;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IWebSocketMessageService webSocketMessageService;

    @Autowired
    private IControlService controlService;

    @Autowired
    private IDeviceRedisService deviceRedisService;

    @Autowired
    private IWaylineRedisService waylineRedisService;

    @Autowired
    private AbstractControlService abstractControlService;

    @Override
    public void setDrcModeInRedis(String dockSn, String clientId) {
        RedisOpsUtils.setWithExpire(RedisConst.DRC_PREFIX + dockSn, clientId, RedisConst.DRC_MODE_ALIVE_SECOND);
    }

    @Override
    public String getDrcModeInRedis(String dockSn) {
        return (String) RedisOpsUtils.get(RedisConst.DRC_PREFIX + dockSn);
    }

    @Override
    public Boolean delDrcModeInRedis(String dockSn) {
        return RedisOpsUtils.del(RedisConst.DRC_PREFIX + dockSn);
    }

    @Override
    public DrcModeMqttBroker userDrcAuth(String workspaceId, String userId, String username, DrcConnectParam param) {

        // refresh token
        String clientId = param.getClientId();
        // first time
        if (!StringUtils.hasText(clientId) || !RedisOpsUtils.checkExist(RedisConst.MQTT_ACL_PREFIX + clientId)) {
            clientId = userId + "-" + System.currentTimeMillis();
            RedisOpsUtils.hashSet(RedisConst.MQTT_ACL_PREFIX + clientId, "", MqttAclAccessEnum.ALL.getValue());
        }

        String key = RedisConst.MQTT_ACL_PREFIX + clientId;

        try {
            RedisOpsUtils.expireKey(key, RedisConst.DRC_MODE_ALIVE_SECOND);

            return MqttPropertyConfiguration.getMqttBrokerWithDrc(
                    clientId, username, param.getExpireSec(), Collections.emptyMap());
        } catch (RuntimeException e) {
            RedisOpsUtils.del(key);
            throw e;
        }
    }

    private void checkDrcModeCondition(String workspaceId, String dockSn) {
        Optional<EventsReceiver<FlighttaskProgress>> runningOpt = waylineRedisService.getRunningWaylineJob(dockSn);
        if (runningOpt.isPresent() && WaylineJobStatusEnum.IN_PROGRESS == waylineJobService.getWaylineState(dockSn)) {
            flighttaskService.updateJobStatus(workspaceId, runningOpt.get().getBid(),
                    UpdateJobParam.builder().status(WaylineTaskStatusEnum.PAUSE).build());
        }

        DockModeCodeEnum dockMode = deviceService.getDockMode(dockSn);
        Optional<DeviceDTO> dockOpt = deviceRedisService.getDeviceOnline(dockSn);
        if (dockOpt.isPresent() && (DockModeCodeEnum.IDLE == dockMode || DockModeCodeEnum.WORKING == dockMode)) {
            Optional<OsdDockDrone> deviceOsd = deviceRedisService.getDeviceOsd(dockOpt.get().getChildDeviceSn(), OsdDockDrone.class);
            if (deviceOsd.isEmpty() || deviceOsd.get().getElevation() <= 0) {
                throw new RuntimeException("The drone is not in the sky and cannot enter command flight mode.");
            }
        } else {
            throw new RuntimeException("The current state of the dock does not support entering command flight mode.");
        }

        HttpResultResponse result = controlService.seizeAuthority(dockSn, DroneAuthorityEnum.FLIGHT, null);
        if (HttpResultResponse.CODE_SUCCESS != result.getCode()) {
            throw new IllegalArgumentException(result.getMessage());
        }

    }

    @Override
    public JwtAclDTO deviceDrcEnter(String workspaceId, DrcModeParam param) {
        String topic = TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + param.getDockSn() + TopicConst.DRC;
        String pubTopic = topic + TopicConst.DOWN;
        String subTopic = topic + TopicConst.UP;

        // If the dock is in drc mode, refresh the permissions directly.
        if (deviceService.checkDockDrcMode(param.getDockSn())
                && param.getClientId().equals(this.getDrcModeInRedis(param.getDockSn()))) {
            refreshAcl(param.getDockSn(), param.getClientId(), topic, subTopic);
            return JwtAclDTO.builder().sub(List.of(subTopic)).pub(List.of(pubTopic)).build();
        }

        checkDrcModeCondition(workspaceId, param.getDockSn());

        TopicServicesResponse<ServicesReplyData> reply = abstractControlService.drcModeEnter(
                SDKManager.getDeviceSDK(param.getDockSn()),
                new DrcModeEnterRequest()
                        .setMqttBroker(MqttPropertyConfiguration.getMqttBrokerWithDrc(param.getDockSn() + "-" + System.currentTimeMillis(), param.getDockSn(),
                                RedisConst.DRC_MODE_ALIVE_SECOND.longValue(),
                                Map.of(MapKeyConst.ACL, objectMapper.convertValue(JwtAclDTO.builder()
                                        .pub(List.of(subTopic))
                                        .sub(List.of(pubTopic))
                                        .build(), new TypeReference<Map<String, ?>>() {
                                }))))
                        .setHsiFrequency(1).setOsdFrequency(10));

        if (!reply.getData().getResult().isSuccess()) {
            throw new RuntimeException("SN: " + param.getDockSn() + "; Error:" + reply.getData().getResult() +
                    "; Failed to enter command flight control mode, please try again later!");
        }

        refreshAcl(param.getDockSn(), param.getClientId(), pubTopic, subTopic);
        return JwtAclDTO.builder().sub(List.of(subTopic)).pub(List.of(pubTopic)).build();
    }

    private void refreshAcl(String dockSn, String clientId, String pubTopic, String subTopic) {
        this.setDrcModeInRedis(dockSn, clientId);

        // assign acl，Match by clientId. https://www.emqx.io/docs/zh/v4.4/advanced/acl-redis.html
        // scheme: HSET mqtt_acl:[clientid] [topic] [access]
        String key = RedisConst.MQTT_ACL_PREFIX + clientId;
        RedisOpsUtils.hashSet(key, pubTopic, MqttAclAccessEnum.PUB.getValue());
        RedisOpsUtils.hashSet(key, subTopic, MqttAclAccessEnum.SUB.getValue());
        RedisOpsUtils.expireKey(key, RedisConst.DRC_MODE_ALIVE_SECOND);
    }

    @Override
    public void deviceDrcExit(String workspaceId, DrcModeParam param) {
        if (!deviceService.checkDockDrcMode(param.getDockSn())) {
            throw new RuntimeException("The dock is not in flight control mode.");
        }
        TopicServicesResponse<ServicesReplyData> reply =
                abstractControlService.drcModeExit(SDKManager.getDeviceSDK(param.getDockSn()));
        if (!reply.getData().getResult().isSuccess()) {
            throw new RuntimeException("SN: " + param.getDockSn() + "; Error:" +
                    reply.getData().getResult() + "; Failed to exit command flight control mode, please try again later!");
        }

        String jobId = waylineRedisService.getPausedWaylineJobId(param.getDockSn());
        if (StringUtils.hasText(jobId)) {
            flighttaskService.updateJobStatus(workspaceId, jobId, UpdateJobParam.builder().status(WaylineTaskStatusEnum.RESUME).build());
        }

        this.delDrcModeInRedis(param.getDockSn());
        RedisOpsUtils.del(RedisConst.MQTT_ACL_PREFIX + param.getClientId());
    }

}
