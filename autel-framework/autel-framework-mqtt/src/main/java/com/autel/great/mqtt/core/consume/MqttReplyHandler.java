package com.autel.great.mqtt.core.consume;


import com.autel.great.context.base.BaseModel;
import com.autel.great.context.base.Common;
import com.autel.great.mqtt.core.CommonTopicRequest;
import com.autel.great.mqtt.core.CommonTopicResponse;
import com.autel.great.mqtt.handle.events.TopicEventsRequest;
import com.autel.great.mqtt.handle.events.TopicEventsResponse;
import com.autel.great.mqtt.handle.requests.TopicRequestsRequest;
import com.autel.great.mqtt.handle.requests.TopicRequestsResponse;
import com.autel.great.mqtt.handle.state.TopicStateRequest;
import com.autel.great.mqtt.handle.state.TopicStateResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class MqttReplyHandler {

    @AfterReturning(value = "execution(public com.autel.great.mqtt.core.CommonTopicResponse+ com.autel.*.api.*.*(com.autel.great.mqtt.core.CommonTopicRequest+, org.springframework.messaging.MessageHeaders))", returning = "result")
    public Object validateReturnValue(JoinPoint point, CommonTopicResponse result) {
        if (Objects.isNull(result)) {
            return null;
        }
        CommonTopicRequest request = (CommonTopicRequest) point.getArgs()[0];
        result.setBid(request.getBid()).setTid(request.getTid()).setTimestamp(System.currentTimeMillis());
        if (result instanceof TopicEventsResponse) {
            fillEvents((TopicEventsResponse) result, (TopicEventsRequest) request);
        } else if (result instanceof TopicRequestsResponse) {
            validateRequests((TopicRequestsResponse) result, (TopicRequestsRequest) request);
        } else if (result instanceof TopicStateResponse) {
            fillState((TopicStateResponse) result, (TopicStateRequest) request);
        }
        return result;
    }

    private void fillEvents(TopicEventsResponse response, TopicEventsRequest request) {
        if (!request.isNeedReply()) {
            response.setData(null);
            return;
        }
        response.setMethod(request.getMethod()).setData(MqttReply.success());
    }

    private void validateRequests(TopicRequestsResponse response, TopicRequestsRequest request) {
        response.setMethod(request.getMethod());
        Object data = response.getData();
        if (data instanceof MqttReply) {
            MqttReply mqttData = (MqttReply) data;
            if (MqttReply.CODE_SUCCESS != mqttData.getResult()) {
                return;
            }
            data = mqttData.getOutput();
        }
        Common.validateModel((BaseModel) data);
    }

    private void fillState(TopicStateResponse response, TopicStateRequest request) {
        response.setData(request.isNeedReply() ? MqttReply.success() : null);
    }
}
