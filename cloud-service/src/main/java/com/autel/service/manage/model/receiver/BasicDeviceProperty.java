package com.autel.service.manage.model.receiver;


import com.autel.great.mqtt.model.device.OsdDockDrone;

public abstract class BasicDeviceProperty {

    public boolean valid() {
        return false;
    }

    public boolean canPublish(OsdDockDrone osd) {
        return valid();
    }
}
