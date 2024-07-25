package com.autel.api.debug;

import com.autel.great.context.annotations.CloudSDKVersion;
import com.autel.great.context.base.BaseModel;
import com.autel.great.context.base.Common;
import com.autel.great.context.enums.version.CloudSDKVersionEnum;
import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.context.enums.version.GatewayTypeEnum;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.context.utils.SpringBeanUtils;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.enums.debug.DebugMethodEnum;
import com.autel.great.mqtt.handle.events.EventsDataRequest;
import com.autel.great.mqtt.handle.events.TopicEventsRequest;
import com.autel.great.mqtt.handle.events.TopicEventsResponse;
import com.autel.great.mqtt.model.debug.*;
import com.autel.great.mqtt.handle.services.ServicesPublish;
import com.autel.great.mqtt.handle.services.ServicesReplyData;
import com.autel.great.mqtt.handle.services.TopicServicesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractDebugService {

    @Resource
    private ServicesPublish servicesPublish;

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> debugModeOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.DEBUG_MODE_OPEN.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> debugModeClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.DEBUG_MODE_CLOSE.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> supplementLightOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.SUPPLEMENT_LIGHT_OPEN.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> supplementLightClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.SUPPLEMENT_LIGHT_CLOSE.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> batteryMaintenanceSwitch(GatewayManager gateway, BatteryMaintenanceSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.BATTERY_MAINTENANCE_SWITCH.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> airConditionerModeSwitch(GatewayManager gateway, AirConditionerModeSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.AIR_CONDITIONER_MODE_SWITCH.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> alarmStateSwitch(GatewayManager gateway, AlarmStateSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.ALARM_STATE_SWITCH.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> batteryStoreModeSwitch(GatewayManager gateway, BatteryStoreModeSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.BATTERY_STORE_MODE_SWITCH.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> deviceReboot(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.DEVICE_REBOOT.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> droneOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.DRONE_OPEN.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> droneClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.DRONE_CLOSE.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> deviceFormat(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.DEVICE_FORMAT.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> droneFormat(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.DRONE_FORMAT.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> coverOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.COVER_OPEN.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> coverClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.COVER_CLOSE.getMethod());
    }

    @CloudSDKVersion(exclude = {GatewayTypeEnum.RC, GatewayTypeEnum.DOCK2})
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> putterOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.PUTTER_OPEN.getMethod());
    }

    @CloudSDKVersion(exclude = {GatewayTypeEnum.RC, GatewayTypeEnum.DOCK2})
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> putterClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.PUTTER_CLOSE.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> chargeOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.CHARGE_OPEN.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> chargeClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.CHARGE_CLOSE.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> sdrWorkmodeSwitch(GatewayManager gateway, SdrWorkmodeSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.SDR_WORKMODE_SWITCH.getMethod(),
                request);
    }

    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> remoteDebug(GatewayManager gateway, DebugMethodEnum methodEnum, BaseModel request) {
        try {
            List<Class> clazz = new ArrayList<>();
            List<Object> args = new ArrayList<>();
            clazz.add(GatewayManager.class);
            args.add(gateway);
            if (Objects.nonNull(request)) {
                clazz.add(request.getClass());
                args.add(request);
            }
            AbstractDebugService abstractDebugService = SpringBeanUtils.getBean(this.getClass());
            Method method = abstractDebugService.getClass().getDeclaredMethod(Common.convertSnake(methodEnum.getMethod()), clazz.toArray(Class[]::new));
            return (TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>>) method.invoke(abstractDebugService, args.toArray());
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new CloudSDKException(e);
        } catch (InvocationTargetException e) {
            throw new CloudSDKException(e.getTargetException());
        }
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_CONTROL_PROGRESS, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> remoteDebugProgress(TopicEventsRequest<EventsDataRequest<RemoteDebugProgress>> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("remoteDebugProgress not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_1, include = GatewayTypeEnum.DOCK2)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> esimActivate(GatewayManager gateway, EsimActivateRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.ESIM_ACTIVATE.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_1, include = GatewayTypeEnum.DOCK2)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> simSlotSwitch(GatewayManager gateway, SimSlotSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.SIM_SLOT_SWITCH.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_1, include = GatewayTypeEnum.DOCK2)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> esimOperatorSwitch(GatewayManager gateway, EsimOperatorSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {
                },
                gateway.getGatewaySn(),
                DebugMethodEnum.ESIM_OPERATOR_SWITCH.getMethod(),
                request);
    }


}
