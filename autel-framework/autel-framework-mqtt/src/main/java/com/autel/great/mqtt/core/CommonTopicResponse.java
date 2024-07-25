package com.autel.great.mqtt.core;

public class CommonTopicResponse<T> {

    protected String tid;

    protected String bid;

    protected T data;

    protected Long timestamp;

    @Override
    public String toString() {
        return "CommonTopicResponse{" +
                "tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }

    public CommonTopicResponse() {
    }

    public String getTid() {
        return tid;
    }

    public CommonTopicResponse<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public CommonTopicResponse<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public T getData() {
        return data;
    }

    public CommonTopicResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public CommonTopicResponse<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}