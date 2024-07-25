package com.autel.great.mqtt.handle.property;

import com.autel.great.mqtt.core.CommonTopicResponse;

public class TopicPropertySetResponse<T> extends CommonTopicResponse<T> {

    @Override
    public String toString() {
        return "TopicPropertySetResponse{" +
                "tid='" + tid + '\'' +
                ", bid='" + bid + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }

    public TopicPropertySetResponse() {
    }

    public String getTid() {
        return tid;
    }

    public TopicPropertySetResponse<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public TopicPropertySetResponse<T> setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public T getData() {
        return data;
    }

    public TopicPropertySetResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public TopicPropertySetResponse<T> setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}