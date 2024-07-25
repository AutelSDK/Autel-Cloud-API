package com.autel.great.mqtt.handle.state;

import com.autel.great.context.base.Common;
import com.autel.great.context.exception.CloudSDKErrorEnum;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.constant.TopicConst;
import com.autel.great.mqtt.core.SDKManager;
import com.autel.great.mqtt.core.produce.MqttGatewayPublish;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Configuration
public class StateRouter {

    @Resource
    private MqttGatewayPublish gatewayPublish;

    @Bean
    public IntegrationFlow stateDataRouterFlow() {
        return IntegrationFlows
                .from(ChannelName.INBOUND_STATE)
                .transform(Message.class, source -> {
                    try {
                        TopicStateRequest response = Common.getObjectMapper().readValue((byte[]) source.getPayload(), new TypeReference<TopicStateRequest>() {
                        });
                        log.info("【state】 router log info print:{}", response);
                        String topic = String.valueOf(source.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
                        String from = topic.substring((TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT).length(), topic.indexOf(TopicConst.STATE_SUF));
                        return response.setFrom(from).setData(Common.getObjectMapper().convertValue(response.getData(), getTypeReference(response.getGateway(), response.getData())));
                    } catch (IOException e) {
                        throw new CloudSDKException(e);
                    }
                }, null)
                .<TopicStateRequest, StateDataKeyEnum>route(response -> StateDataKeyEnum.find(response.getData().getClass()),
                        mapping -> Arrays.stream(StateDataKeyEnum.values()).forEach(key -> mapping.channelMapping(key, key.getChannelName())))
                .get();
    }


    @Bean
    public IntegrationFlow replySuccessState() {
        return IntegrationFlows
                .from(ChannelName.OUTBOUND_STATE)
                .handle(this::publish)
                .nullChannel();

    }

    private TopicStateResponse publish(TopicStateResponse request, MessageHeaders headers) {
        if (Objects.isNull(request) || Objects.isNull(request.getData())) {
            return null;
        }
        gatewayPublish.publishReply(request, headers);
        return request;
    }


    private Class getTypeReference(String gatewaySn, Object data) {
        Set<String> keys = ((Map<String, Object>) data).keySet();
        switch (SDKManager.getDeviceSDK(gatewaySn).getType()) {
            case RC:
                return RcStateDataKeyEnum.find(keys).getClassType();
            case DOCK:
            case DOCK2:
                return DockStateDataKeyEnum.find(keys).getClassType();
            case EVO_DOCK:
                return EvoDockStateDataKeyEnum.find(keys).getClassType();
            case EVO_AV_DOCK:
                return EvoAvDockStateDataKeyEnum.find(keys).getClassType();
            case EVO_AD_DOCK:
                return EvoAdDockStateDataKeyEnum.find(keys).getClassType();
            default:
                throw new CloudSDKException(CloudSDKErrorEnum.WRONG_DATA, "Unexpected value: " + SDKManager.getDeviceSDK(gatewaySn).getType());
        }
    }
}