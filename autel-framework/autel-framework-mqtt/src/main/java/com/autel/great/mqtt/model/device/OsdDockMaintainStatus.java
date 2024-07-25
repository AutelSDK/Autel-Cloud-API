package com.autel.great.mqtt.model.device;

import java.util.List;
public class OsdDockMaintainStatus {

    private List<DockMaintainStatus> maintainStatusArray;

    public OsdDockMaintainStatus() {
    }

    @Override
    public String toString() {
        return "OsdDroneMaintainStatus{" +
                "maintainStatusArray=" + maintainStatusArray +
                '}';
    }

    public List<DockMaintainStatus> getMaintainStatusArray() {
        return maintainStatusArray;
    }

    public OsdDockMaintainStatus setMaintainStatusArray(List<DockMaintainStatus> maintainStatusArray) {
        this.maintainStatusArray = maintainStatusArray;
        return this;
    }
}
