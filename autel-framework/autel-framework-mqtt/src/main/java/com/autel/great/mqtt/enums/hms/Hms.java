package com.autel.great.mqtt.enums.hms;

import com.autel.great.mqtt.model.hms.DeviceHms;

import java.util.List;

public class Hms {

    private List<DeviceHms> list;

    public Hms() {
    }

    @Override
    public String toString() {
        return "Hms{" +
                "list=" + list +
                '}';
    }

    public List<DeviceHms> getList() {
        return list;
    }

    public Hms setList(List<DeviceHms> list) {
        this.list = list;
        return this;
    }
}
