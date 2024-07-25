package com.autel.great.mqtt.handle.services;


import com.autel.great.mqtt.core.CommonTopicResponse;

public class TopicServicesResponse<T> extends CommonTopicResponse<T> {

    private String method;

    @Override
    public String toString() {
        return "TopicServicesResponse{" +
                "tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", method='" + method + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }

    public TopicServicesResponse() {
    }

    public String getTid() {
        return tid;
    }

    public TopicServicesResponse<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicServicesResponse<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public TopicServicesResponse<T> setMethod(String method) {
        this.method = method;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicServicesResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicServicesResponse<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}