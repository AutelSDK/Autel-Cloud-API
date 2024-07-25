package com.autel.great.mqtt.model.device;

import java.util.List;

public class OsdDroneMaintainStatus {

    private List<DroneMaintainStatus> maintainStatusArray;

    public OsdDroneMaintainStatus() {
    }

    @Override
    public String toString() {
        return "OsdDroneMaintainStatus{" +
                "maintainStatusArray=" + maintainStatusArray +
                '}';
    }

    public List<DroneMaintainStatus> getMaintainStatusArray() {
        return maintainStatusArray;
    }

    public OsdDroneMaintainStatus setMaintainStatusArray(List<DroneMaintainStatus> maintainStatusArray) {
        this.maintainStatusArray = maintainStatusArray;
        return this;
    }
}
