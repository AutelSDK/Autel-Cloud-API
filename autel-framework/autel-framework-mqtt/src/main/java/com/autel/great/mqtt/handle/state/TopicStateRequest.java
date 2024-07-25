package com.autel.great.mqtt.handle.state;


import com.autel.great.mqtt.core.CommonTopicRequest;

public class TopicStateRequest<T> extends CommonTopicRequest<T> {

    private String gateway;

    private String from;

    private boolean needReply;

    public TopicStateRequest() {
    }

    @Override
    public String toString() {
        return "TopicStateRequest{" +
                "gateway='" + gateway + '\'' +
                ", from='" + from + '\'' +
                ", needReply=" + needReply +
                ", tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public TopicStateRequest<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicStateRequest<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicStateRequest<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicStateRequest<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getGateway() {
        return gateway;
    }

    public TopicStateRequest<T> setGateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public TopicStateRequest<T> setFrom(String from) {
        this.from = from;
        return this;
    }

    public boolean isNeedReply() {
        return needReply;
    }

    public TopicStateRequest<T> setNeedReply(boolean needReply) {
        this.needReply = needReply;
        return this;
    }
}
