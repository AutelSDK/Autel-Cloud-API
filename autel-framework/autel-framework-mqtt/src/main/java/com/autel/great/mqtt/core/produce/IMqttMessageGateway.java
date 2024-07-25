package com.autel.great.mqtt.core.produce;

import com.autel.great.mqtt.constant.ChannelName;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = ChannelName.OUTBOUND)
public interface IMqttMessageGateway {

    void publish(@Header(MqttHeaders.TOPIC) String topic, byte[] payload);

    void publish(@Header(MqttHeaders.TOPIC) String topic, byte[] payload, @Header(MqttHeaders.QOS) int qos);
}
