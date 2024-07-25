package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.control.ExposureCameraTypeEnum;
import com.autel.great.mqtt.enums.control.ExposureValueEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class CameraExposureSetRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    private ExposureCameraTypeEnum cameraType;

    @NotNull
    private ExposureValueEnum exposureValue;

    public CameraExposureSetRequest() {
    }

    @Override
    public String toString() {
        return "CameraExposureSetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", cameraType=" + cameraType +
                ", exposureValue=" + exposureValue +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraExposureSetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public ExposureCameraTypeEnum getCameraType() {
        return cameraType;
    }

    public CameraExposureSetRequest setCameraType(ExposureCameraTypeEnum cameraType) {
        this.cameraType = cameraType;
        return this;
    }

    public ExposureValueEnum getExposureValue() {
        return exposureValue;
    }

    public CameraExposureSetRequest setExposureValue(ExposureValueEnum exposureValue) {
        this.exposureValue = exposureValue;
        return this;
    }
}
