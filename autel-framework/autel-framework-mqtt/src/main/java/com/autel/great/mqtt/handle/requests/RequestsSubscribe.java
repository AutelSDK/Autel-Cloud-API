package com.autel.great.mqtt.handle.requests;

import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.mqtt.constant.TopicConst;
import com.autel.great.mqtt.core.subscribe.IMqttTopicService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RequestsSubscribe {

    public static final String TOPIC = TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + "%s" + TopicConst.REQUESTS_SUF;

    @Resource
    private IMqttTopicService topicService;

    public void subscribe(GatewayManager gateway) {
        topicService.subscribe(String.format(TOPIC, gateway.getGatewaySn()));
    }

    public void unsubscribe(GatewayManager gateway) {
        topicService.unsubscribe(String.format(TOPIC, gateway.getGatewaySn()));
    }

    public void subscribeWildcardsRequests() {
        topicService.subscribe(TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + "+" + TopicConst.REQUESTS_SUF);
    }
}
