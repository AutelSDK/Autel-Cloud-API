package com.autel.great.mqtt.core.consume;

import com.autel.great.context.utils.SpringBeanUtils;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.enums.base.CloudApiTopicEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * Channel selection
 */
@Slf4j
@Component
public class InboundMessageRouter extends AbstractMessageRouter {
    @Override
    @Router(inputChannel = ChannelName.INBOUND)
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        MessageHeaders headers = message.getHeaders();
        String topic = headers.get(MqttHeaders.RECEIVED_TOPIC).toString();
        byte[] payload = (byte[]) message.getPayload();

        log.debug("received topic: {} \t payload =>{}", topic, new String(payload));

        CloudApiTopicEnum topicEnum = CloudApiTopicEnum.find(topic);
        MessageChannel bean = (MessageChannel) SpringBeanUtils.getBean(topicEnum.getBeanName());
        return Collections.singleton(bean);
    }
}
