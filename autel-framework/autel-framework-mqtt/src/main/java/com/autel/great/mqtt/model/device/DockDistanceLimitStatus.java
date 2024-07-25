package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.SwitchActionEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DockDistanceLimitStatus {

    private SwitchActionEnum state;

    private Integer distanceLimit;

    @JsonProperty("is_near_distance_limit")
    private Boolean nearDistanceLimit;

    public DockDistanceLimitStatus() {
    }

    @Override
    public String toString() {
        return "DockDistanceLimitStatusSet{" +
                "state=" + state +
                ", distanceLimit=" + distanceLimit +
                ", nearDistanceLimit=" + nearDistanceLimit +
                '}';
    }

    public SwitchActionEnum getState() {
        return state;
    }

    public DockDistanceLimitStatus setState(SwitchActionEnum state) {
        this.state = state;
        return this;
    }

    public Integer getDistanceLimit() {
        return distanceLimit;
    }

    public DockDistanceLimitStatus setDistanceLimit(Integer distanceLimit) {
        this.distanceLimit = distanceLimit;
        return this;
    }

    public Boolean getNearDistanceLimit() {
        return nearDistanceLimit;
    }

    public DockDistanceLimitStatus setNearDistanceLimit(Boolean nearDistanceLimit) {
        this.nearDistanceLimit = nearDistanceLimit;
        return this;
    }
}
