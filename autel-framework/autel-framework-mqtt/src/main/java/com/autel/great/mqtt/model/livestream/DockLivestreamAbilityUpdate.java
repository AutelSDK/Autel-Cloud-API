package com.autel.great.mqtt.model.livestream;

public class DockLivestreamAbilityUpdate {

    private DockLiveCapacity liveCapacity;

    public DockLivestreamAbilityUpdate() {
    }

    @Override
    public String toString() {
        return "DockLivestreamAbilityUpdate{" +
                "liveCapacity=" + liveCapacity +
                '}';
    }

    public DockLiveCapacity getLiveCapacity() {
        return liveCapacity;
    }

    public DockLivestreamAbilityUpdate setLiveCapacity(DockLiveCapacity liveCapacity) {
        this.liveCapacity = liveCapacity;
        return this;
    }
}
