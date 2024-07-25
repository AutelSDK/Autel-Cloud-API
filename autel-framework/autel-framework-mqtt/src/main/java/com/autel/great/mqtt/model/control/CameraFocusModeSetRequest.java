package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.control.ExposureCameraTypeEnum;
import com.autel.great.mqtt.enums.control.FocusModeEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class CameraFocusModeSetRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    private ExposureCameraTypeEnum cameraType;

    @NotNull
    private FocusModeEnum focusMode;

    public CameraFocusModeSetRequest() {
    }

    @Override
    public String toString() {
        return "CameraFocusModeSetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", cameraType=" + cameraType +
                ", focusMode=" + focusMode +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraFocusModeSetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public ExposureCameraTypeEnum getCameraType() {
        return cameraType;
    }

    public CameraFocusModeSetRequest setCameraType(ExposureCameraTypeEnum cameraType) {
        this.cameraType = cameraType;
        return this;
    }

    public FocusModeEnum getFocusMode() {
        return focusMode;
    }

    public CameraFocusModeSetRequest setFocusMode(FocusModeEnum focusMode) {
        this.focusMode = focusMode;
        return this;
    }
}
