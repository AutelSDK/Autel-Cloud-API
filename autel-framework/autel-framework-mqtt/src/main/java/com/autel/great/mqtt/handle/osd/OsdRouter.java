package com.autel.great.mqtt.handle.osd;

import com.autel.great.context.base.Common;
import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.constant.TopicConst;
import com.autel.great.mqtt.core.SDKManager;
import com.autel.great.mqtt.model.device.PayloadModelConst;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
public class OsdRouter {

    @Bean
    public IntegrationFlow osdRouterFlow() {
        return IntegrationFlows
                .from(ChannelName.INBOUND_OSD)
                .transform(Message.class, source -> {
                    try {
                        TopicOsdRequest response = Common.getObjectMapper().readValue((byte[]) source.getPayload(), new TypeReference<TopicOsdRequest>() {
                        });
                        String topic = String.valueOf(source.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
                        return response.setFrom(topic.substring((TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT).length(), topic.indexOf(TopicConst.OSD_SUF)));
                    } catch (IOException e) {
                        throw new CloudSDKException(e);
                    }
                }, null).<TopicOsdRequest>handle((response, headers) -> {
                    GatewayManager gateway = SDKManager.getDeviceSDK(response.getGateway());
                    OsdDeviceTypeEnum typeEnum = OsdDeviceTypeEnum.find(gateway.getType(), response.getFrom().equals(response.getGateway()));
                    Map<String, Object> data = (Map<String, Object>) response.getData();
                    if (!typeEnum.isGateway()) {
                        List payloadData = (List) data.getOrDefault(PayloadModelConst.PAYLOAD_KEY, new ArrayList<>());
                        PayloadModelConst.getAllIndexWithPosition().stream().filter(data::containsKey).map(data::get).forEach(payloadData::add);
                        data.put(PayloadModelConst.PAYLOAD_KEY, payloadData);
                    }
                    return response.setData(Common.getObjectMapper().convertValue(data, typeEnum.getClassType()));
                }).<TopicOsdRequest, OsdDeviceTypeEnum>route(response -> OsdDeviceTypeEnum.find(response.getData().getClass()), mapping -> Arrays.stream(OsdDeviceTypeEnum.values()).forEach(key -> mapping.channelMapping(key, key.getChannelName()))).get();
    }

}