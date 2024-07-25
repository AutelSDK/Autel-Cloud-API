package com.autel.api.hms;

import com.autel.great.mqtt.enums.hms.Hms;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.handle.events.TopicEventsRequest;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

public abstract class AbstractHmsService {

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_HMS)
    public void hms(TopicEventsRequest<Hms> response, MessageHeaders headers) {
        throw new UnsupportedOperationException("hms not implemented");
    }

}
