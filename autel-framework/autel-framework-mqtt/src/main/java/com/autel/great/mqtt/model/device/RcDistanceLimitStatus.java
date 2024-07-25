package com.autel.great.mqtt.model.device;

public class RcDistanceLimitStatus {

    private Integer state;

    private Integer distanceLimit;

    public RcDistanceLimitStatus() {
    }

    @Override
    public String toString() {
        return "RcDistanceLimitStatusSet{" +
                "state=" + state +
                ", distanceLimit=" + distanceLimit +
                '}';
    }

    public Integer getState() {
        return state;
    }

    public RcDistanceLimitStatus setState(Integer state) {
        this.state = state;
        return this;
    }

    public Integer getDistanceLimit() {
        return distanceLimit;
    }

    public RcDistanceLimitStatus setDistanceLimit(Integer distanceLimit) {
        this.distanceLimit = distanceLimit;
        return this;
    }
}
