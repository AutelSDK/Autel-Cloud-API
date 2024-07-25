package com.autel.api.media;

import com.autel.great.context.annotations.CloudSDKVersion;
import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.context.enums.version.GatewayTypeEnum;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.enums.media.MediaMethodEnum;
import com.autel.great.mqtt.handle.events.TopicEventsRequest;
import com.autel.great.mqtt.handle.events.TopicEventsResponse;
import com.autel.great.mqtt.model.media.FileUploadCallback;
import com.autel.great.mqtt.model.media.HighestPriorityUploadFlightTaskMedia;
import com.autel.great.mqtt.model.media.StorageConfigGet;
import com.autel.great.mqtt.model.media.UploadFlighttaskMediaPrioritize;
import com.autel.great.mqtt.model.storage.StsCredentialsResponse;
import com.autel.great.mqtt.handle.requests.TopicRequestsRequest;
import com.autel.great.mqtt.handle.requests.TopicRequestsResponse;
import com.autel.great.mqtt.handle.services.ServicesPublish;
import com.autel.great.mqtt.handle.services.ServicesReplyData;
import com.autel.great.mqtt.handle.services.TopicServicesResponse;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;

public abstract class AbstractMediaService {

    @Resource
    private ServicesPublish servicesPublish;

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_FILE_UPLOAD_CALLBACK, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> fileUploadCallback(TopicEventsRequest<FileUploadCallback> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("fileUploadCallback not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_HIGHEST_PRIORITY_UPLOAD_FLIGHT_TASK_MEDIA, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> highestPriorityUploadFlightTaskMedia(TopicEventsRequest<HighestPriorityUploadFlightTaskMedia> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("highestPriorityUploadFlightTaskMedia not implemented");
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> uploadFlighttaskMediaPrioritize(GatewayManager gateway, UploadFlighttaskMediaPrioritize request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                MediaMethodEnum.UPLOAD_FLIGHTTASK_MEDIA_PRIORITIZE.getMethod(),
                request);
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_REQUESTS_STORAGE_CONFIG_GET, outputChannel = ChannelName.OUTBOUND_REQUESTS)
    public TopicRequestsResponse<MqttReply<StsCredentialsResponse>> storageConfigGet(TopicRequestsRequest<StorageConfigGet> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("storageConfigGet not implemented");
    }

}
