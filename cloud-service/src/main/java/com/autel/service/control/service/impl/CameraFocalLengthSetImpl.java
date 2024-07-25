package com.autel.service.control.service.impl;

import com.autel.great.mqtt.enums.control.CameraTypeEnum;
import com.autel.great.mqtt.enums.device.CameraStateEnum;
import com.autel.service.control.model.param.DronePayloadParam;

import java.util.Objects;

public class CameraFocalLengthSetImpl extends PayloadCommandsHandler {

    public CameraFocalLengthSetImpl(DronePayloadParam param) {
        super(param);
    }

    @Override
    public boolean valid() {
        return Objects.nonNull(param.getCameraType()) && Objects.nonNull(param.getZoomFactor())
                && (CameraTypeEnum.ZOOM == param.getCameraType()
                || CameraTypeEnum.IR == param.getCameraType());
    }

    @Override
    public boolean canPublish(String deviceSn) {
        super.canPublish(deviceSn);
        if (CameraStateEnum.WORKING == osdCamera.getPhotoState()) {
            return false;
        }
        switch (param.getCameraType()) {
            case IR:
                return Objects.nonNull(osdCamera.getIrZoomFactor())
                        && param.getZoomFactor().intValue() != osdCamera.getIrZoomFactor();
            case ZOOM:
                return param.getZoomFactor().intValue() != osdCamera.getZoomFactor();
        }
        return false;
    }
}
