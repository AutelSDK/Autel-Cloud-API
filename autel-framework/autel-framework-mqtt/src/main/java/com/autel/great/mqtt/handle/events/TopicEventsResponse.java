package com.autel.great.mqtt.handle.events;


import com.autel.great.mqtt.core.CommonTopicResponse;

public class TopicEventsResponse<T> extends CommonTopicResponse<T> {

    private String method;

    @Override
    public String toString() {
        return "TopicEventsResponse{" +
                "tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", method='" + method + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }

    public TopicEventsResponse() {
    }

    public String getTid() {
        return tid;
    }

    public TopicEventsResponse<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicEventsResponse<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public TopicEventsResponse<T> setMethod(String method) {
        this.method = method;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicEventsResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicEventsResponse<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}