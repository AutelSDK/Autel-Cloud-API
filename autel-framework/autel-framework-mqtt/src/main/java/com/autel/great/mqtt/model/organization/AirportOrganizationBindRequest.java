package com.autel.great.mqtt.model.organization;

import java.util.List;

public class AirportOrganizationBindRequest {

    private List<OrganizationBindDevice> bindDevices;

    public AirportOrganizationBindRequest() {
    }

    @Override
    public String toString() {
        return "AirportOrganizationBindRequest{" +
                "bindDevices=" + bindDevices +
                '}';
    }

    public List<OrganizationBindDevice> getBindDevices() {
        return bindDevices;
    }

    public AirportOrganizationBindRequest setBindDevices(List<OrganizationBindDevice> bindDevices) {
        this.bindDevices = bindDevices;
        return this;
    }
}
