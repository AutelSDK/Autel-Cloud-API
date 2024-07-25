package com.autel.service.wayline.service.impl;

import com.autel.great.context.error.CommonErrorEnum;
import com.autel.great.mqtt.enums.wayline.FlighttaskStatusEnum;
import com.autel.great.mqtt.model.wayline.*;
import com.autel.great.websocket.enums.BizCodeEnum;
import com.autel.great.websocket.enums.UserTypeEnum;
import com.autel.great.websocket.service.IWebSocketMessageService;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.handle.events.EventsDataRequest;
import com.autel.great.mqtt.handle.events.TopicEventsRequest;
import com.autel.great.mqtt.handle.events.TopicEventsResponse;
import com.autel.great.mqtt.core.EventsReceiver;
import com.autel.great.mqtt.handle.requests.TopicRequestsRequest;
import com.autel.great.mqtt.handle.requests.TopicRequestsResponse;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.service.IDeviceRedisService;
import com.autel.service.media.model.MediaFileCountDTO;
import com.autel.service.media.service.IMediaRedisService;
import com.autel.service.wayline.model.dto.WaylineJobDTO;
import com.autel.service.wayline.model.enums.WaylineJobStatusEnum;
import com.autel.service.wayline.service.IWaylineFileService;
import com.autel.service.wayline.service.IWaylineJobService;
import com.autel.service.wayline.service.IWaylineRedisService;
import com.autel.api.wayline.AbstractWaylineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class SDKWaylineService extends AbstractWaylineService {

    @Autowired
    private IDeviceRedisService deviceRedisService;

    @Autowired
    private IWaylineRedisService waylineRedisService;

    @Autowired
    private IMediaRedisService mediaRedisService;

    @Autowired
    private IWebSocketMessageService webSocketMessageService;

    @Autowired
    private IWaylineJobService waylineJobService;

    @Autowired
    private IWaylineFileService waylineFileService;

    @Override
    public TopicEventsResponse<MqttReply> deviceExitHomingNotify(TopicEventsRequest<DeviceExitHomingNotify> request, MessageHeaders headers) {
        return super.deviceExitHomingNotify(request, headers);
    }

    @Override
    public TopicEventsResponse<MqttReply> flighttaskProgress(TopicEventsRequest<EventsDataRequest<FlighttaskProgress>> response, MessageHeaders headers) {
        EventsReceiver<FlighttaskProgress> eventsReceiver = new EventsReceiver<>();
        eventsReceiver.setResult(response.getData().getResult());
        eventsReceiver.setOutput(response.getData().getOutput());
        eventsReceiver.setBid(response.getBid());
        eventsReceiver.setSn(response.getGateway());

        FlighttaskProgress output = eventsReceiver.getOutput();
        log.info("Task progress: {}", output.getProgress().toString());
        if (!eventsReceiver.getResult().isSuccess()) {
            log.error("Task progress ===> Error: " + eventsReceiver.getResult());
        }

        Optional<DeviceDTO> deviceOpt = deviceRedisService.getDeviceOnline(response.getGateway());
        if (deviceOpt.isEmpty()) {
            return new TopicEventsResponse<>();
        }

        FlighttaskStatusEnum statusEnum = output.getStatus();
        waylineRedisService.setRunningWaylineJob(response.getGateway(), eventsReceiver);

        if (statusEnum.isEnd()) {
            WaylineJobDTO job = WaylineJobDTO.builder()
                    .jobId(response.getBid())
                    .status(WaylineJobStatusEnum.SUCCESS.getVal())
                    .completedTime(LocalDateTime.now())
                    .mediaCount(output.getExt().getMediaCount())
                    .build();

            // record the update of the media count.
            if (Objects.nonNull(job.getMediaCount()) && job.getMediaCount() != 0) {
                mediaRedisService.setMediaCount(response.getGateway(), job.getJobId(),
                        MediaFileCountDTO.builder().deviceSn(deviceOpt.get().getChildDeviceSn())
                                .jobId(response.getBid()).mediaCount(job.getMediaCount()).uploadedCount(0).build());
            }

            if (FlighttaskStatusEnum.OK != statusEnum) {
                job.setCode(eventsReceiver.getResult().getCode());
                job.setStatus(WaylineJobStatusEnum.FAILED.getVal());
            }
            waylineJobService.updateJob(job);
            waylineRedisService.delRunningWaylineJob(response.getGateway());
            waylineRedisService.delPausedWaylineJob(response.getBid());
        }

        webSocketMessageService.sendBatch(deviceOpt.get().getWorkspaceId(), UserTypeEnum.WEB.getVal(),
                BizCodeEnum.FLIGHT_TASK_PROGRESS.getCode(), eventsReceiver);

        return new TopicEventsResponse<>();
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public TopicRequestsResponse<MqttReply<FlighttaskResourceGetResponse>> flighttaskResourceGet(TopicRequestsRequest<FlighttaskResourceGetRequest> response, MessageHeaders headers) {
        String jobId = response.getData().getFlightId();

        Optional<DeviceDTO> deviceOpt = deviceRedisService.getDeviceOnline(response.getGateway());
        if (deviceOpt.isEmpty()) {
            log.error("The device is offline, please try again later.");
            return new TopicRequestsResponse().setData(MqttReply.error(CommonErrorEnum.DEVICE_OFFLINE));
        }
        Optional<WaylineJobDTO> waylineJobOpt = waylineJobService.getJobByJobId(deviceOpt.get().getWorkspaceId(), jobId);
        if (waylineJobOpt.isEmpty()) {
            log.error("The wayline job does not exist.");
            return new TopicRequestsResponse().setData(MqttReply.error(CommonErrorEnum.ILLEGAL_ARGUMENT));
        }

        WaylineJobDTO waylineJob = waylineJobOpt.get();

        Optional<GetWaylineListResponse> waylineFile = waylineFileService.getWaylineByWaylineId(waylineJob.getWorkspaceId(), waylineJob.getFileId());
        if (waylineFile.isEmpty()) {
            log.error("The wayline file does not exist.");
            return new TopicRequestsResponse().setData(MqttReply.error(CommonErrorEnum.ILLEGAL_ARGUMENT));
        }
        try {
            URL url = waylineFileService.getObjectUrl(waylineJob.getWorkspaceId(), waylineFile.get().getId());
            return new TopicRequestsResponse<MqttReply<FlighttaskResourceGetResponse>>().setData(
                    MqttReply.success(new FlighttaskResourceGetResponse()
                            .setFile(new FlighttaskFile()
                                    .setUrl(url.toString())
                                    .setFingerprint(waylineFile.get().getSign()))));
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            return new TopicRequestsResponse().setData(MqttReply.error(CommonErrorEnum.SYSTEM_ERROR));
        }
    }
}
