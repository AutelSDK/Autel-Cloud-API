package com.autel.great.mqtt.core;

public class CommonTopicRequest<T> {

    protected String tid;

    protected String bid;

    protected Long timestamp;

    protected T data;

    public CommonTopicRequest() {
    }

    @Override
    public String toString() {
        return "CommonTopicRequest{" +
                "tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public CommonTopicRequest<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public CommonTopicRequest<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public CommonTopicRequest<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public T getData() {
        return data;
    }

    public CommonTopicRequest<T> setData(T data) {
        this.data = data;
        return this;
    }
}