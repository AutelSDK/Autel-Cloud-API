package com.autel.great.mqtt.model.organization;

import java.util.List;

public class AirportBindStatusRequest {

    private List<BindStatusResponseDevice> devices;

    public AirportBindStatusRequest() {
    }

    @Override
    public String toString() {
        return "AirportBindStatusRequest{" +
                "devices=" + devices +
                '}';
    }

    public List<BindStatusResponseDevice> getDevices() {
        return devices;
    }

    public AirportBindStatusRequest setDevices(List<BindStatusResponseDevice> devices) {
        this.devices = devices;
        return this;
    }
}
