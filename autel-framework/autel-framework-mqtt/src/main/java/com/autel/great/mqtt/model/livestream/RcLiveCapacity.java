package com.autel.great.mqtt.model.livestream;

import java.util.List;

public class RcLiveCapacity {

    private Integer availableVideoNumber;

    /**
     * Maximum total number of video streams that can be lived stream simultaneously.
     */
    private Integer coexistVideoNumberMax;

    /**
     * Device live streaming capability list
     */
    private List<RcLiveCapacityDevice> deviceList;

    public RcLiveCapacity() {
    }

    @Override
    public String toString() {
        return "RcLiveCapacity{" +
                "availableVideoNumber=" + availableVideoNumber +
                ", coexistVideoNumberMax=" + coexistVideoNumberMax +
                ", deviceList=" + deviceList +
                '}';
    }

    public Integer getAvailableVideoNumber() {
        return availableVideoNumber;
    }

    public RcLiveCapacity setAvailableVideoNumber(Integer availableVideoNumber) {
        this.availableVideoNumber = availableVideoNumber;
        return this;
    }

    public Integer getCoexistVideoNumberMax() {
        return coexistVideoNumberMax;
    }

    public RcLiveCapacity setCoexistVideoNumberMax(Integer coexistVideoNumberMax) {
        this.coexistVideoNumberMax = coexistVideoNumberMax;
        return this;
    }

    public List<RcLiveCapacityDevice> getDeviceList() {
        return deviceList;
    }

    public RcLiveCapacity setDeviceList(List<RcLiveCapacityDevice> deviceList) {
        this.deviceList = deviceList;
        return this;
    }
}
