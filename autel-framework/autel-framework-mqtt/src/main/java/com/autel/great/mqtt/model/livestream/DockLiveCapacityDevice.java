package com.autel.great.mqtt.model.livestream;

import java.util.List;

public class DockLiveCapacityDevice {

    /**
     * Device serial number
     */
    private String sn;

    /**
     * Total number of video streams that can be used for livestreaming
     * Total number of video streams used for livestreaming that belongs to devices.
     */
    private Integer availableVideoNumber;

    /**
     * Maximum number of video streams that can be used for livestreaming at the same time
     */
    private Integer coexistVideoNumberMax;

    /**
     * Camera list on the device
     */
    private List<DockLiveCapacityCamera> cameraList;

    public DockLiveCapacityDevice() {
    }

    @Override
    public String toString() {
        return "DockLiveCapacityDevice{" +
                "sn='" + sn + '\'' +
                ", availableVideoNumber=" + availableVideoNumber +
                ", coexistVideoNumberMax=" + coexistVideoNumberMax +
                ", cameraList=" + cameraList +
                '}';
    }

    public String getSn() {
        return sn;
    }

    public DockLiveCapacityDevice setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public Integer getAvailableVideoNumber() {
        return availableVideoNumber;
    }

    public DockLiveCapacityDevice setAvailableVideoNumber(Integer availableVideoNumber) {
        this.availableVideoNumber = availableVideoNumber;
        return this;
    }

    public Integer getCoexistVideoNumberMax() {
        return coexistVideoNumberMax;
    }

    public DockLiveCapacityDevice setCoexistVideoNumberMax(Integer coexistVideoNumberMax) {
        this.coexistVideoNumberMax = coexistVideoNumberMax;
        return this;
    }

    public List<DockLiveCapacityCamera> getCameraList() {
        return cameraList;
    }

    public DockLiveCapacityDevice setCameraList(List<DockLiveCapacityCamera> cameraList) {
        this.cameraList = cameraList;
        return this;
    }
}