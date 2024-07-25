package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.MaintainTypeEnum;

public class DockMaintainStatus {

    private Integer lastMaintainFlightSorties;

    private Long lastMaintainTime;

    private MaintainTypeEnum lastMaintainType;

    private Boolean state;

    public DockMaintainStatus() {
    }

    @Override
    public String toString() {
        return "DroneMaintainStatus{" +
                "lastMaintainFlightSorties=" + lastMaintainFlightSorties +
                ", lastMaintainTime=" + lastMaintainTime +
                ", lastMaintainType=" + lastMaintainType +
                ", state=" + state +
                '}';
    }

    public Integer getLastMaintainFlightSorties() {
        return lastMaintainFlightSorties;
    }

    public DockMaintainStatus setLastMaintainFlightSorties(Integer lastMaintainFlightSorties) {
        this.lastMaintainFlightSorties = lastMaintainFlightSorties;
        return this;
    }

    public Long getLastMaintainTime() {
        return lastMaintainTime;
    }

    public DockMaintainStatus setLastMaintainTime(Long lastMaintainTime) {
        this.lastMaintainTime = lastMaintainTime;
        return this;
    }

    public MaintainTypeEnum getLastMaintainType() {
        return lastMaintainType;
    }

    public DockMaintainStatus setLastMaintainType(MaintainTypeEnum lastMaintainType) {
        this.lastMaintainType = lastMaintainType;
        return this;
    }

    public Boolean getState() {
        return state;
    }

    public DockMaintainStatus setState(Boolean state) {
        this.state = state;
        return this;
    }
}
