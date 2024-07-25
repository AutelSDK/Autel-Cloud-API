package com.autel.great.mqtt.model.device;

import java.util.List;

public class RcLiveStatus {

    private List<RcLiveStatusData> liveStatus;

    public RcLiveStatus() {
    }

    @Override
    public String toString() {
        return "RcLiveStatus{" +
                "liveStatus=" + liveStatus +
                '}';
    }

    public List<RcLiveStatusData> getLiveStatus() {
        return liveStatus;
    }

    public RcLiveStatus setLiveStatus(List<RcLiveStatusData> liveStatus) {
        this.liveStatus = liveStatus;
        return this;
    }
}