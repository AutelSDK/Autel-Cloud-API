package com.autel.great.mqtt.model.control;

import java.util.List;

public class DelayInfoPush {

    private Integer sdrCmdDelay;

    private List<LiveviewDelay> liveviewDelayList;

    public DelayInfoPush() {
    }

    @Override
    public String toString() {
        return "DelayInfoPush{" +
                "sdrCmdDelay=" + sdrCmdDelay +
                ", liveviewDelayList=" + liveviewDelayList +
                '}';
    }

    public Integer getSdrCmdDelay() {
        return sdrCmdDelay;
    }

    public DelayInfoPush setSdrCmdDelay(Integer sdrCmdDelay) {
        this.sdrCmdDelay = sdrCmdDelay;
        return this;
    }

    public List<LiveviewDelay> getLiveviewDelayList() {
        return liveviewDelayList;
    }

    public DelayInfoPush setLiveviewDelayList(List<LiveviewDelay> liveviewDelayList) {
        this.liveviewDelayList = liveviewDelayList;
        return this;
    }
}
