package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class CameraRecordingStartRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    public CameraRecordingStartRequest() {
    }

    @Override
    public String toString() {
        return "CameraRecordingStartRequest{" +
                "payloadIndex=" + payloadIndex +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraRecordingStartRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }
}
