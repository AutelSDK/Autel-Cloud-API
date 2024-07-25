package com.autel.great.mqtt.core.subscribe;

import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

public interface IMqttTopicService {

    void subscribe(@Header(MqttHeaders.TOPIC) String... topics);

    void subscribe(@Header(MqttHeaders.TOPIC) String topic, int qos);

    void unsubscribe(@Header(MqttHeaders.TOPIC) String... topics);

    String[] getSubscribedTopic();
}
