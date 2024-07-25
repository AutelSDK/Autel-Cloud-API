package com.autel.great.mqtt.handle.property;

import com.autel.great.context.base.Common;
import com.autel.great.mqtt.core.sync.Chan;
import com.autel.great.mqtt.constant.ChannelName;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class PropertySetReplyHandler {

    private static final String RESULT_KEY = "result";

    @ServiceActivator(inputChannel = ChannelName.INBOUND_PROPERTY_SET_REPLY)
    public void propertySetReply(Message<?> message) throws IOException {
        byte[] payload = (byte[])message.getPayload();

        TopicPropertySetResponse receiver = Common.getObjectMapper().readValue(payload, new TypeReference<TopicPropertySetResponse>() {});
        Chan chan = Chan.getInstance(receiver.getTid(), false);
        if (Objects.isNull(chan)) {
            return;
        }
        receiver.setData(PropertySetReplyResultEnum.find(
                Common.getObjectMapper().convertValue(receiver.getData(), JsonNode.class).findValue(RESULT_KEY).intValue()));
        chan.put(receiver);
    }
}
