package com.autel.great.mqtt.handle.services;


import com.autel.great.mqtt.core.CommonTopicRequest;

public class TopicServicesRequest<T> extends CommonTopicRequest<T> {

    private String method;

    public TopicServicesRequest() {
    }

    @Override
    public String toString() {
        return "TopicServicesRequest{" +
                "method='" + method + '\'' +
                ", tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }

    public String getMethod() {
        return method;
    }

    public TopicServicesRequest<T> setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getTid() {
        return tid;
    }

    public TopicServicesRequest<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicServicesRequest<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicServicesRequest<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicServicesRequest<T> setData(T data) {
        this.data = data;
        return this;
    }

}
