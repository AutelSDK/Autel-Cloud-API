package com.autel.great.mqtt.model.control;


import com.autel.great.context.base.BaseModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class HeartBeatRequest extends BaseModel {

    @NotNull
    private Long seq;

    @NotNull
    @Min(123456789012L)
    private Long timestamp;

    public HeartBeatRequest() {
    }

    @Override
    public String toString() {
        return "HeartBeatRequest{" +
                "seq=" + seq +
                ", timestamp=" + timestamp +
                '}';
    }

    public Long getSeq() {
        return seq;
    }

    public HeartBeatRequest setSeq(Long seq) {
        this.seq = seq;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public HeartBeatRequest setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
