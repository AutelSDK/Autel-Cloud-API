package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class CameraPhotoTakeRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    public CameraPhotoTakeRequest() {
    }

    @Override
    public String toString() {
        return "CameraPhotoTakeRequest{" +
                "payloadIndex=" + payloadIndex +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraPhotoTakeRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }
}
