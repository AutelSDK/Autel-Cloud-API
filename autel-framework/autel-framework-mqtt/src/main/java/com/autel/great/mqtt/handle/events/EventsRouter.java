package com.autel.great.mqtt.handle.events;

import com.autel.great.context.base.Common;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.core.produce.MqttGatewayPublish;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.constant.TopicConst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@Configuration
public class EventsRouter {

    @Resource
    private MqttGatewayPublish gatewayPublish;

    @Bean
    public IntegrationFlow eventsMethodRouterFlow() {
        return IntegrationFlows
                .from(ChannelName.INBOUND_EVENTS)
                .transform(Message.class, source -> {
                    try {
                        TopicEventsRequest data = Common.getObjectMapper().readValue((byte[]) source.getPayload(), TopicEventsRequest.class);
                        String topic = String.valueOf(source.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
                        return data.setFrom(topic.substring((TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT).length(), topic.indexOf(TopicConst.EVENTS_SUF)))
                                .setData(Common.getObjectMapper().convertValue(data.getData(), EventsMethodEnum.find(data.getMethod()).getClassType()));
                    } catch (IOException e) {
                        throw new CloudSDKException(e);
                    }
                }, null)
                .<TopicEventsRequest, EventsMethodEnum>route(
                        response -> EventsMethodEnum.find(response.getMethod()),
                        mapping -> Arrays.stream(EventsMethodEnum.values()).forEach(
                                methodEnum -> mapping.channelMapping(methodEnum, methodEnum.getChannelName())))
                .get();
    }

    @Bean
    public IntegrationFlow replySuccessEvents() {
        return IntegrationFlows
                .from(ChannelName.OUTBOUND_EVENTS)
                .handle(this::publish)
                .nullChannel();

    }

    private TopicEventsResponse publish(TopicEventsResponse request, MessageHeaders headers) {
        if (Objects.isNull(request) || Objects.isNull(request.getData())) {
            return null;
        }
        gatewayPublish.publishReply(request, headers);
        return request;
    }

}
