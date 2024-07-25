package com.autel.great.mqtt.model.device;

import java.util.List;

public class DockLiveStatus {

    private List<DockLiveStatusData> liveStatus;

    public DockLiveStatus() {
    }

    @Override
    public String toString() {
        return "DockLiveStatus{" +
                "liveStatus=" + liveStatus +
                '}';
    }

    public List<DockLiveStatusData> getLiveStatus() {
        return liveStatus;
    }

    public DockLiveStatus setLiveStatus(List<DockLiveStatusData> liveStatus) {
        this.liveStatus = liveStatus;
        return this;
    }
}