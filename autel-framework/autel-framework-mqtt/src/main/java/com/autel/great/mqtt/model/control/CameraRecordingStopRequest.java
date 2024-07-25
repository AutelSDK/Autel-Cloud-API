package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class CameraRecordingStopRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    public CameraRecordingStopRequest() {
    }

    @Override
    public String toString() {
        return "CameraRecordingStopRequest{" +
                "payloadIndex=" + payloadIndex +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraRecordingStopRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }
}
