package com.autel.great.mqtt.handle.status;


import com.autel.great.mqtt.core.CommonTopicResponse;

public class TopicStatusResponse<T> extends CommonTopicResponse<T> {

    private String method;

    @Override
    public String toString() {
        return "TopicStatusResponse{" +
                "tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", method='" + method + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }

    public TopicStatusResponse() {
    }

    public String getTid() {
        return tid;
    }

    public TopicStatusResponse<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicStatusResponse<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public TopicStatusResponse<T> setMethod(String method) {
        this.method = method;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicStatusResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicStatusResponse<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}