package com.autel.great.mqtt.handle.requests;


import com.autel.great.mqtt.core.CommonTopicResponse;

public class TopicRequestsResponse<T> extends CommonTopicResponse<T> {

    private String method;

    @Override
    public String toString() {
        return "TopicRequestsResponse{" +
                "tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", method='" + method + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }

    public TopicRequestsResponse() {
    }

    public String getTid() {
        return tid;
    }

    public TopicRequestsResponse<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicRequestsResponse<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public TopicRequestsResponse<T> setMethod(String method) {
        this.method = method;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicRequestsResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicRequestsResponse<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}