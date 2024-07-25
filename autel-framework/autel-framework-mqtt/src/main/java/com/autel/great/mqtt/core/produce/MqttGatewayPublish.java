package com.autel.great.mqtt.core.produce;

import com.autel.great.context.base.Common;
import com.autel.great.context.exception.CloudSDKErrorEnum;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.constant.TopicConst;
import com.autel.great.mqtt.core.CommonTopicRequest;
import com.autel.great.mqtt.core.CommonTopicResponse;
import com.autel.great.mqtt.core.sync.Chan;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MqttGatewayPublish {

    private static final Logger log = LoggerFactory.getLogger(MqttGatewayPublish.class);

    private static final int DEFAULT_QOS = 0;
    public static final int DEFAULT_RETRY_COUNT = 2;
    public static final int DEFAULT_RETRY_TIMEOUT = 3000;

    @Resource
    private IMqttMessageGateway messageGateway;

    public void publish(String topic, int qos, CommonTopicRequest request) {
        try {
            log.debug("send topic: {}, payload: {}", topic, request.toString());
            byte[] payload = Common.getObjectMapper().writeValueAsBytes(request);
            messageGateway.publish(topic, payload, qos);
        } catch (JsonProcessingException e) {
            log.error("Failed to publish the message. {}", request.toString());
            e.printStackTrace();
        }
    }

    public void publish(String topic, int qos, CommonTopicResponse response) {
        try {
            log.debug("send topic: {}, payload: {}", topic, response.toString());
            byte[] payload = Common.getObjectMapper().writeValueAsBytes(response);
            messageGateway.publish(topic, payload, qos);
        } catch (JsonProcessingException e) {
            log.error("Failed to publish the message. {}", response.toString());
            e.printStackTrace();
        }
    }

    public void publish(String topic, CommonTopicRequest request, int publishCount) {
        AtomicInteger time = new AtomicInteger(0);
        while (time.getAndIncrement() < publishCount) {
            this.publish(topic, DEFAULT_QOS, request);
        }
    }

    public void publish(String topic, CommonTopicRequest request) {
        this.publish(topic, DEFAULT_QOS, request);
    }

    public void publishReply(CommonTopicResponse response, MessageHeaders headers) {
        this.publish(headers.get(MqttHeaders.RECEIVED_TOPIC) + TopicConst._REPLY_SUF, 2, response);
    }

    public <T> CommonTopicResponse<T> publishWithReply(Class<T> clazz, String topic, CommonTopicRequest request, int retryCount, long timeout) {
        AtomicInteger time = new AtomicInteger(0);
        boolean hasBid = StringUtils.hasText(request.getBid());
        request.setBid(hasBid ? request.getBid() : UUID.randomUUID().toString());
        while (time.getAndIncrement() <= retryCount) {
            this.publish(topic, request);

            CommonTopicResponse<T> receiver = Chan.getInstance(request.getTid(), true).get(request.getTid(), timeout);
            if (Objects.nonNull(receiver)
                    && receiver.getTid().equals(request.getTid())
                    && receiver.getBid().equals(request.getBid())) {
                if (clazz.isAssignableFrom(receiver.getData().getClass())) {
                    return receiver;
                }
                throw new TypeMismatchException(receiver.getData(), clazz);
            }
            if (!hasBid) {
                request.setBid(UUID.randomUUID().toString());
            }
            request.setTid(UUID.randomUUID().toString());
        }
        throw new CloudSDKException(CloudSDKErrorEnum.MQTT_PUBLISH_ABNORMAL, "No message reply received.");
    }


}