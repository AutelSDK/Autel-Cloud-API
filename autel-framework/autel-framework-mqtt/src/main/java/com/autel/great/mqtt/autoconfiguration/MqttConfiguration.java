package com.autel.great.mqtt.autoconfiguration;

import com.autel.great.mqtt.constant.ChannelName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import javax.annotation.Resource;
import java.util.UUID;

@Configuration
@IntegrationComponentScan
public class MqttConfiguration {

    private static final Logger log = LoggerFactory.getLogger(MqttConfiguration.class);

    @Value("${cloud-sdk.mqtt.inbound-topic: }")
    private String inboundTopic;

    @Resource
    private MqttPahoClientFactory mqttClientFactory;

    @Resource(name = ChannelName.INBOUND)
    private MessageChannel inboundChannel;

    @Bean
    public MqttPahoMessageDrivenChannelAdapter mqttInbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(UUID.randomUUID().toString(), mqttClientFactory, inboundTopic.split(","));
        DefaultPahoMessageConverter converter = new DefaultPahoMessageConverter();
        converter.setPayloadAsBytes(true);
        adapter.setConverter(converter);
        adapter.setQos(1);
        adapter.setOutputChannel(inboundChannel);
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = ChannelName.OUTBOUND)
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(UUID.randomUUID().toString(), mqttClientFactory);
        DefaultPahoMessageConverter converter = new DefaultPahoMessageConverter();
        converter.setPayloadAsBytes(true);
        messageHandler.setAsync(true);
        messageHandler.setDefaultQos(0);
        messageHandler.setConverter(converter);
        return messageHandler;
    }

    @Bean
    @ServiceActivator(inputChannel = ChannelName.DEFAULT)
    public MessageHandler defaultInboundHandler() {
        return message -> {
            log.info("The default channel does not handle messages." +
                    "\nTopic: " + message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC) +
                    "\nPayload: " + message.getPayload() + "\n");
        };
    }
}
