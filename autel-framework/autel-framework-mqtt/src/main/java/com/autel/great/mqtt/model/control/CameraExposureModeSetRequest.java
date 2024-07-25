package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.control.ExposureCameraTypeEnum;
import com.autel.great.mqtt.enums.control.ExposureModeEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class CameraExposureModeSetRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    private ExposureCameraTypeEnum cameraType;

    @NotNull
    private ExposureModeEnum exposureMode;

    public CameraExposureModeSetRequest() {
    }

    @Override
    public String toString() {
        return "CameraExposureModeSetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", cameraType=" + cameraType +
                ", exposureMode=" + exposureMode +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraExposureModeSetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public ExposureCameraTypeEnum getCameraType() {
        return cameraType;
    }

    public CameraExposureModeSetRequest setCameraType(ExposureCameraTypeEnum cameraType) {
        this.cameraType = cameraType;
        return this;
    }

    public ExposureModeEnum getExposureMode() {
        return exposureMode;
    }

    public CameraExposureModeSetRequest setExposureMode(ExposureModeEnum exposureMode) {
        this.exposureMode = exposureMode;
        return this;
    }
}
