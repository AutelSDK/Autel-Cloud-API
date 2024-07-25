package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.MaintainTypeEnum;

public class DroneMaintainStatus {

    private Integer lastMaintainFlightSorties;

    private Integer lastMaintainFlightTime;

    private Long lastMaintainTime;

    private MaintainTypeEnum lastMaintainType;

    private Boolean state;

    public DroneMaintainStatus() {
    }

    @Override
    public String toString() {
        return "DroneMaintainStatus{" +
                "lastMaintainFlightSorties=" + lastMaintainFlightSorties +
                ", lastMaintainFlightTime=" + lastMaintainFlightTime +
                ", lastMaintainTime=" + lastMaintainTime +
                ", lastMaintainType=" + lastMaintainType +
                ", state=" + state +
                '}';
    }

    public Integer getLastMaintainFlightSorties() {
        return lastMaintainFlightSorties;
    }

    public DroneMaintainStatus setLastMaintainFlightSorties(Integer lastMaintainFlightSorties) {
        this.lastMaintainFlightSorties = lastMaintainFlightSorties;
        return this;
    }

    public Integer getLastMaintainFlightTime() {
        return lastMaintainFlightTime;
    }

    public DroneMaintainStatus setLastMaintainFlightTime(Integer lastMaintainFlightTime) {
        this.lastMaintainFlightTime = lastMaintainFlightTime;
        return this;
    }

    public Long getLastMaintainTime() {
        return lastMaintainTime;
    }

    public DroneMaintainStatus setLastMaintainTime(Long lastMaintainTime) {
        this.lastMaintainTime = lastMaintainTime;
        return this;
    }

    public MaintainTypeEnum getLastMaintainType() {
        return lastMaintainType;
    }

    public DroneMaintainStatus setLastMaintainType(MaintainTypeEnum lastMaintainType) {
        this.lastMaintainType = lastMaintainType;
        return this;
    }

    public Boolean getState() {
        return state;
    }

    public DroneMaintainStatus setState(Boolean state) {
        this.state = state;
        return this;
    }
}
