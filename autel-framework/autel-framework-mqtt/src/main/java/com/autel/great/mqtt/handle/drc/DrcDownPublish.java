package com.autel.great.mqtt.handle.drc;

import com.autel.great.mqtt.core.produce.MqttGatewayPublish;
import com.autel.great.mqtt.constant.TopicConst;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class DrcDownPublish {

    @Resource
    private MqttGatewayPublish gatewayPublish;

    public static final int DEFAULT_PUBLISH_COUNT = 5;

    public void publish(String sn, String method) {
        this.publish(sn, method, null);
    }

    public void publish(String sn, String method, Object data) {
        this.publish(sn, method, data, DEFAULT_PUBLISH_COUNT);
    }

    public void publish(String sn, String method, Object data, int publishCount) {
        String topic = TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + Objects.requireNonNull(sn) + TopicConst.DRC + TopicConst.DOWN;
        gatewayPublish.publish(topic,
                new TopicDrcRequest<>()
                        .setMethod(method)
                        .setData(Objects.requireNonNullElse(data, "")),
                publishCount);
    }

}
