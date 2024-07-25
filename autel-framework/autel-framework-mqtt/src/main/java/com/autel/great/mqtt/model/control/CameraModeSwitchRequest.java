package com.autel.great.mqtt.model.control;


import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.device.CameraModeEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class CameraModeSwitchRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    private CameraModeEnum cameraMode;

    public CameraModeSwitchRequest() {
    }

    @Override
    public String toString() {
        return "CameraModeSwitchRequest{" +
                "payloadIndex=" + payloadIndex +
                ", cameraMode=" + cameraMode +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraModeSwitchRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public CameraModeEnum getCameraMode() {
        return cameraMode;
    }

    public CameraModeSwitchRequest setCameraMode(CameraModeEnum cameraMode) {
        this.cameraMode = cameraMode;
        return this;
    }
}
