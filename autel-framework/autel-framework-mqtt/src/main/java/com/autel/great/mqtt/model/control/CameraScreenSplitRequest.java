package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class CameraScreenSplitRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    private Boolean enable;

    public CameraScreenSplitRequest() {
    }

    @Override
    public String toString() {
        return "CameraScreenSplitRequest{" +
                "payloadIndex=" + payloadIndex +
                ", enable=" + enable +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraScreenSplitRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public Boolean getEnable() {
        return enable;
    }

    public CameraScreenSplitRequest setEnable(Boolean enable) {
        this.enable = enable;
        return this;
    }
}
