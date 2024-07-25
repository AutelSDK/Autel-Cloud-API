package com.autel.api.log;

import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.enums.log.LogMethodEnum;
import com.autel.great.mqtt.handle.events.EventsDataRequest;
import com.autel.great.mqtt.handle.events.TopicEventsRequest;
import com.autel.great.mqtt.handle.events.TopicEventsResponse;
import com.autel.great.mqtt.model.log.*;
import com.autel.great.mqtt.handle.services.ServicesPublish;
import com.autel.great.mqtt.handle.services.ServicesReplyData;
import com.autel.great.mqtt.handle.services.TopicServicesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;

public abstract class AbstractLogService {

    @Resource
    private ServicesPublish servicesPublish;

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_FILEUPLOAD_PROGRESS, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> fileuploadProgress(TopicEventsRequest<EventsDataRequest<FileUploadProgress>> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("fileuploadProgress not implemented");
    }

    public TopicServicesResponse<ServicesReplyData<FileUploadListResponse>> fileuploadList(GatewayManager gateway, FileUploadListRequest request) {
        return servicesPublish.publish(
                new TypeReference<FileUploadListResponse>() {
                },
                gateway.getGatewaySn(),
                LogMethodEnum.FILE_UPLOAD_LIST.getMethod(),
                request);
    }

    public TopicServicesResponse<ServicesReplyData> fileuploadStart(GatewayManager gateway, FileUploadStartRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                LogMethodEnum.FILE_UPLOAD_START.getMethod(),
                request);
    }

    public TopicServicesResponse<ServicesReplyData> fileuploadUpdate(GatewayManager gateway, FileUploadUpdateRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                LogMethodEnum.FILE_UPLOAD_UPDATE.getMethod(),
                request);
    }

}
