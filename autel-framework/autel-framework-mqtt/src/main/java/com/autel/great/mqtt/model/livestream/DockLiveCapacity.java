package com.autel.great.mqtt.model.livestream;

import java.util.List;

public class DockLiveCapacity {

    private Integer availableVideoNumber;

    private Integer coexistVideoNumberMax;

    private List<DockLiveCapacityDevice> deviceList;

    public DockLiveCapacity() {
    }

    @Override
    public String toString() {
        return "DockLiveCapacity{" +
                "availableVideoNumber=" + availableVideoNumber +
                ", coexistVideoNumberMax=" + coexistVideoNumberMax +
                ", deviceList=" + deviceList +
                '}';
    }

    public Integer getAvailableVideoNumber() {
        return availableVideoNumber;
    }

    public DockLiveCapacity setAvailableVideoNumber(Integer availableVideoNumber) {
        this.availableVideoNumber = availableVideoNumber;
        return this;
    }

    public Integer getCoexistVideoNumberMax() {
        return coexistVideoNumberMax;
    }

    public DockLiveCapacity setCoexistVideoNumberMax(Integer coexistVideoNumberMax) {
        this.coexistVideoNumberMax = coexistVideoNumberMax;
        return this;
    }

    public List<DockLiveCapacityDevice> getDeviceList() {
        return deviceList;
    }

    public DockLiveCapacity setDeviceList(List<DockLiveCapacityDevice> deviceList) {
        this.deviceList = deviceList;
        return this;
    }
}
