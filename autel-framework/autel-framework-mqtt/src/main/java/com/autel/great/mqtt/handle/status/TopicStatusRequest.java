package com.autel.great.mqtt.handle.status;


import com.autel.great.mqtt.core.CommonTopicRequest;

public class TopicStatusRequest<T> extends CommonTopicRequest<T> {

    private String method;

    private String from;

    public TopicStatusRequest() {
    }

    @Override
    public String toString() {
        return "TopicStatusRequest{" +
                "method='" + method + '\'' +
                ", from='" + from + '\'' +
                ", tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public TopicStatusRequest<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicStatusRequest<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicStatusRequest<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicStatusRequest<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public TopicStatusRequest<T> setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public TopicStatusRequest<T> setFrom(String from) {
        this.from = from;
        return this;
    }
}
