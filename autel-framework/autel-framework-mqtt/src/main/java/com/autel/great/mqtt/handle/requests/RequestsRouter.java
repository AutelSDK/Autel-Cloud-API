package com.autel.great.mqtt.handle.requests;

import com.autel.great.context.base.Common;
import com.autel.great.context.exception.CloudSDKErrorEnum;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.core.produce.MqttGatewayPublish;
import com.autel.great.mqtt.constant.ChannelName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

@Configuration
public class RequestsRouter {

    @Resource
    private MqttGatewayPublish gatewayPublish;

    @Bean
    public IntegrationFlow requestsMethodRouterFlow() {
        return IntegrationFlows
                .from(ChannelName.INBOUND_REQUESTS)
                .<byte[], TopicRequestsRequest>transform(payload -> {
                    try {
                        TopicRequestsRequest response = Common.getObjectMapper().readValue(payload, TopicRequestsRequest.class);
                        return response.setData(Common.getObjectMapper().convertValue(response.getData(), RequestsMethodEnum.find(response.getMethod()).getClassType()));
                    } catch (IOException e) {
                        throw new CloudSDKException(e);
                    }
                })
                .<TopicRequestsRequest, RequestsMethodEnum>route(
                        receiver -> RequestsMethodEnum.find(receiver.getMethod()),
                        mapping -> Arrays.stream(RequestsMethodEnum.values()).forEach(
                                methodEnum -> mapping.channelMapping(methodEnum, methodEnum.getChannelName())))
                .get();
    }

    @Bean
    public IntegrationFlow replyRequestsMethod() {
        return IntegrationFlows
                .from(ChannelName.OUTBOUND_REQUESTS)
                .handle(this::publish)
                .nullChannel();
    }

    private TopicRequestsResponse publish(TopicRequestsResponse request, MessageHeaders headers) {
        if (Objects.isNull(request)) {
            throw new CloudSDKException(CloudSDKErrorEnum.INVALID_PARAMETER, "The return value cannot be null.");
        }
        gatewayPublish.publishReply(request, headers);
        return request;
    }
}
