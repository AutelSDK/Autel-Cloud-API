package com.autel.service.control.service.impl;

import com.autel.great.mqtt.enums.device.CameraStateEnum;
import com.autel.service.control.model.param.DronePayloadParam;

public class CameraPhotoTakeImpl extends PayloadCommandsHandler {

    public CameraPhotoTakeImpl(DronePayloadParam param) {
        super(param);
    }

    @Override
    public boolean canPublish(String deviceSn) {
        super.canPublish(deviceSn);
        return CameraStateEnum.WORKING != osdCamera.getPhotoState() && osdCamera.getRemainPhotoNum() > 0;
    }
}
