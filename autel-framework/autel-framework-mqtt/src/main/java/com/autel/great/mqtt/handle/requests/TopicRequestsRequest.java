package com.autel.great.mqtt.handle.requests;

import com.autel.great.mqtt.core.CommonTopicRequest;

public class TopicRequestsRequest<T> extends CommonTopicRequest<T> {

    private String method;

    private String gateway;

    public TopicRequestsRequest() {
    }

    @Override
    public String toString() {
        return "TopicRequestsRequest{" +
                "method='" + method + '\'' +
                ", gateway='" + gateway + '\'' +
                ", tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public TopicRequestsRequest<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicRequestsRequest<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicRequestsRequest<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicRequestsRequest<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getGateway() {
        return gateway;
    }

    public TopicRequestsRequest<T> setGateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public TopicRequestsRequest<T> setMethod(String method) {
        this.method = method;
        return this;
    }
}
