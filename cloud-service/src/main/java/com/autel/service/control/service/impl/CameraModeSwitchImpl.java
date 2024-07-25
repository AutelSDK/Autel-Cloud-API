package com.autel.service.control.service.impl;

import com.autel.great.mqtt.enums.device.CameraStateEnum;
import com.autel.service.control.model.param.DronePayloadParam;

import java.util.Objects;

public class CameraModeSwitchImpl extends PayloadCommandsHandler {

    public CameraModeSwitchImpl(DronePayloadParam param) {
        super(param);
    }

    @Override
    public boolean valid() {
        return Objects.nonNull(param.getCameraMode());
    }

    @Override
    public boolean canPublish(String deviceSn) {
        super.canPublish(deviceSn);
        return param.getCameraMode() != osdCamera.getCameraMode()
                && CameraStateEnum.IDLE == osdCamera.getPhotoState()
                && CameraStateEnum.IDLE == osdCamera.getRecordingState();
    }
}
