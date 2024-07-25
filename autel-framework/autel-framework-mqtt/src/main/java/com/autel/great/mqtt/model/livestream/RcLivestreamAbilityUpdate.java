package com.autel.great.mqtt.model.livestream;

public class RcLivestreamAbilityUpdate {

    private RcLiveCapacity liveCapacity;

    public RcLivestreamAbilityUpdate() {
    }

    @Override
    public String toString() {
        return "RcLivestreamAbilityUpdate{" +
                "liveCapacity=" + liveCapacity +
                '}';
    }

    public RcLiveCapacity getLiveCapacity() {
        return liveCapacity;
    }

    public RcLivestreamAbilityUpdate setLiveCapacity(RcLiveCapacity liveCapacity) {
        this.liveCapacity = liveCapacity;
        return this;
    }
}
