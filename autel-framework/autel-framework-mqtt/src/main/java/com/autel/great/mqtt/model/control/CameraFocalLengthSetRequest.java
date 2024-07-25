package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.control.ZoomCameraTypeEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CameraFocalLengthSetRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    private ZoomCameraTypeEnum cameraType;

    @Min(2)
    @Max(200)
    @NotNull
    private Float zoomFactor;

    public CameraFocalLengthSetRequest() {
    }

    @Override
    public String toString() {
        return "CameraFocalLengthSetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", cameraType=" + cameraType +
                ", zoomFactor=" + zoomFactor +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraFocalLengthSetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public ZoomCameraTypeEnum getCameraType() {
        return cameraType;
    }

    public CameraFocalLengthSetRequest setCameraType(ZoomCameraTypeEnum cameraType) {
        this.cameraType = cameraType;
        return this;
    }

    public Float getZoomFactor() {
        return zoomFactor;
    }

    public CameraFocalLengthSetRequest setZoomFactor(Float zoomFactor) {
        this.zoomFactor = zoomFactor;
        return this;
    }
}
