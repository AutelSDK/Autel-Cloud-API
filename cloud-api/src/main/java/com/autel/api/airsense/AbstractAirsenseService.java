package com.autel.api.airsense;

import com.autel.great.context.annotations.CloudSDKVersion;
import com.autel.great.context.enums.version.CloudSDKVersionEnum;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.handle.events.TopicEventsRequest;
import com.autel.great.mqtt.handle.events.TopicEventsResponse;
import com.autel.great.mqtt.model.airsense.AirsenseWarning;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import java.util.List;

public abstract class AbstractAirsenseService {

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_AIRSENSE_WARNING, outputChannel = ChannelName.OUTBOUND_EVENTS)
    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    public TopicEventsResponse<MqttReply> airsenseWarning(TopicEventsRequest<List<AirsenseWarning>> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("airsenseWarning not implemented");
    }

}
