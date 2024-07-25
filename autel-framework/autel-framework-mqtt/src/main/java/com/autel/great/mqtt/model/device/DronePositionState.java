package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.PositionFixedEnum;

public class DronePositionState {

    private Integer gpsNumber;

    private PositionFixedEnum isFixed;

    private Integer quality;

    private Integer rtkNumber;

    public DronePositionState() {
    }

    @Override
    public String toString() {
        return "DronePositionState{" +
                "gpsNumber=" + gpsNumber +
                ", isFixed=" + isFixed +
                ", quality=" + quality +
                ", rtkNumber=" + rtkNumber +
                '}';
    }

    public Integer getGpsNumber() {
        return gpsNumber;
    }

    public DronePositionState setGpsNumber(Integer gpsNumber) {
        this.gpsNumber = gpsNumber;
        return this;
    }

    public PositionFixedEnum getIsFixed() {
        return isFixed;
    }

    public DronePositionState setIsFixed(PositionFixedEnum isFixed) {
        this.isFixed = isFixed;
        return this;
    }

    public Integer getQuality() {
        return quality;
    }

    public DronePositionState setQuality(Integer quality) {
        this.quality = quality;
        return this;
    }

    public Integer getRtkNumber() {
        return rtkNumber;
    }

    public DronePositionState setRtkNumber(Integer rtkNumber) {
        this.rtkNumber = rtkNumber;
        return this;
    }
}
