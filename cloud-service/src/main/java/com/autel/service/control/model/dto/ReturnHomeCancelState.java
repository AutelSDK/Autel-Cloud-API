package com.autel.service.control.model.dto;

import com.autel.great.context.utils.SpringBeanUtilsTest;
import com.autel.great.mqtt.enums.device.DroneModeCodeEnum;
import com.autel.great.mqtt.model.device.OsdDockDrone;
import com.autel.service.control.service.impl.RemoteDebugHandler;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.service.IDeviceRedisService;


public class ReturnHomeCancelState extends RemoteDebugHandler {

    @Override
    public boolean canPublish(String sn) {
        IDeviceRedisService deviceRedisService = SpringBeanUtilsTest.getBean(IDeviceRedisService.class);
        return deviceRedisService.getDeviceOnline(sn)
                .map(DeviceDTO::getChildDeviceSn)
                .flatMap(deviceSn -> deviceRedisService.getDeviceOsd(deviceSn, OsdDockDrone.class))
                .map(osd -> DroneModeCodeEnum.RETURN_AUTO == osd.getModeCode())
                .orElse(false);
    }

}
