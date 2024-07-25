package com.autel.service.control.service.impl;

import com.autel.great.context.utils.SpringBeanUtilsTest;
import com.autel.great.mqtt.model.device.OsdCamera;
import com.autel.great.mqtt.model.device.OsdDockDrone;
import com.autel.service.control.model.param.DronePayloadParam;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.service.IDevicePayloadService;
import com.autel.service.manage.service.IDeviceRedisService;

import java.util.Optional;

public abstract class PayloadCommandsHandler {

    DronePayloadParam param;

    OsdCamera osdCamera;

    PayloadCommandsHandler(DronePayloadParam param) {
        this.param = param;
    }

    public boolean valid() {
        return true;
    }

    public boolean canPublish(String deviceSn) {
        Optional<OsdDockDrone> deviceOpt = SpringBeanUtilsTest.getBean(IDeviceRedisService.class)
                .getDeviceOsd(deviceSn, OsdDockDrone.class);
        if (deviceOpt.isEmpty()) {
            throw new RuntimeException("The device is offline.");
        }
        osdCamera = deviceOpt.get().getCameras().stream()
                .filter(osdCamera -> param.getPayloadIndex().equals(osdCamera.getPayloadIndex().toString()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Did not receive osd information about the camera, please check the cache data."));
        return true;
    }

    private String checkDockOnline(String dockSn) {
        Optional<DeviceDTO> deviceOpt = SpringBeanUtilsTest.getBean(IDeviceRedisService.class).getDeviceOnline(dockSn);
        if (deviceOpt.isEmpty()) {
            throw new RuntimeException("The dock is offline.");
        }
        return deviceOpt.get().getChildDeviceSn();
    }

    private void checkDeviceOnline(String deviceSn) {
        boolean isOnline = SpringBeanUtilsTest.getBean(IDeviceRedisService.class).checkDeviceOnline(deviceSn);
        if (!isOnline) {
            throw new RuntimeException("The device is offline.");
        }
    }

    private void checkAuthority(String deviceSn) {
        boolean hasAuthority = SpringBeanUtilsTest.getBean(IDevicePayloadService.class)
                .checkAuthorityPayload(deviceSn, param.getPayloadIndex());
        if (!hasAuthority) {
            throw new RuntimeException("The device does not have payload control authority.");
        }
    }

    public final void checkCondition(String dockSn) {
        if (!valid()) {
            throw new RuntimeException("illegal argument");
        }

        String deviceSn = checkDockOnline(dockSn);
        checkDeviceOnline(deviceSn);
        checkAuthority(deviceSn);

        if (!canPublish(deviceSn)) {
            throw new RuntimeException("The current state of the drone does not support this function, please try again later.");
        }
    }

}
