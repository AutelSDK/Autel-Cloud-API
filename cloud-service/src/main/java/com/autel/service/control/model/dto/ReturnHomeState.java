package com.autel.service.control.model.dto;

import com.autel.great.context.utils.SpringBeanUtilsTest;
import com.autel.great.mqtt.enums.device.DroneModeCodeEnum;
import com.autel.great.mqtt.model.device.OsdDockDrone;
import com.autel.service.control.service.impl.RemoteDebugHandler;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.service.IDeviceRedisService;


public class ReturnHomeState extends RemoteDebugHandler {

    @Override
    public boolean canPublish(String sn) {
        IDeviceRedisService deviceRedisService = SpringBeanUtilsTest.getBean(IDeviceRedisService.class);
        return deviceRedisService.getDeviceOnline(sn)
                .map(DeviceDTO::getChildDeviceSn)
                .flatMap(deviceSn -> deviceRedisService.getDeviceOsd(deviceSn, OsdDockDrone.class))
                .map(osd -> osd.getElevation() > 0 && modeCodeCanReturnHome(osd.getModeCode()))
                .orElse(false);
    }

    private boolean modeCodeCanReturnHome(DroneModeCodeEnum modeCode) {
        return DroneModeCodeEnum.TAKEOFF_FINISHED == modeCode || DroneModeCodeEnum.TAKEOFF_AUTO == modeCode
                || DroneModeCodeEnum.WAYLINE == modeCode || DroneModeCodeEnum.PANORAMIC_SHOT == modeCode
                || DroneModeCodeEnum.ACTIVE_TRACK == modeCode || DroneModeCodeEnum.APAS == modeCode
                || DroneModeCodeEnum.VIRTUAL_JOYSTICK == modeCode || DroneModeCodeEnum.MANUAL == modeCode;
    }
}
