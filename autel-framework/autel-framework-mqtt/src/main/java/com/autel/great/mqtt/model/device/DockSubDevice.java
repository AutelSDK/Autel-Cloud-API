package com.autel.great.mqtt.model.device;

import com.autel.great.context.enums.device.DeviceEnum;

public class DockSubDevice {

    private String deviceSn;

    private Boolean deviceOnlineStatus;

    private Boolean devicePaired;

    private DeviceEnum deviceModelKey;

    public DockSubDevice() {
    }

    @Override
    public String toString() {
        return "DockSubDevice{" +
                "deviceSn='" + deviceSn + '\'' +
                ", deviceOnlineStatus=" + deviceOnlineStatus +
                ", devicePaired=" + devicePaired +
                ", deviceModelKey=" + deviceModelKey +
                '}';
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public DockSubDevice setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
        return this;
    }

    public Boolean getDeviceOnlineStatus() {
        return deviceOnlineStatus;
    }

    public DockSubDevice setDeviceOnlineStatus(Boolean deviceOnlineStatus) {
        this.deviceOnlineStatus = deviceOnlineStatus;
        return this;
    }

    public Boolean getDevicePaired() {
        return devicePaired;
    }

    public DockSubDevice setDevicePaired(Boolean devicePaired) {
        this.devicePaired = devicePaired;
        return this;
    }

    public DeviceEnum getDeviceModelKey() {
        return deviceModelKey;
    }

    public DockSubDevice setDeviceModelKey(DeviceEnum deviceModelKey) {
        this.deviceModelKey = deviceModelKey;
        return this;
    }
}
