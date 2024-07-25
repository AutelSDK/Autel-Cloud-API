package com.autel.great.mqtt.handle.drc;


import com.autel.great.mqtt.core.CommonTopicResponse;

public class TopicDrcResponse<T> extends CommonTopicResponse<T> {

    private String method;

    @Override
    public String toString() {
        return "TopicDrcResponse{" +
                "tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", method='" + method + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }

    public TopicDrcResponse() {
    }

    public String getTid() {
        return tid;
    }

    public TopicDrcResponse<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicDrcResponse<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public TopicDrcResponse<T> setMethod(String method) {
        this.method = method;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicDrcResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicDrcResponse<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}