package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.SwitchActionEnum;

public class ObstacleAvoidance {

    private SwitchActionEnum horizon;

    private SwitchActionEnum upside;

    private SwitchActionEnum downside;

    public ObstacleAvoidance() {
    }

    @Override
    public String toString() {
        return "ObstacleAvoidanceSet{" +
                "horizon=" + horizon +
                ", upside=" + upside +
                ", downside=" + downside +
                '}';
    }

    public SwitchActionEnum getHorizon() {
        return horizon;
    }

    public ObstacleAvoidance setHorizon(SwitchActionEnum horizon) {
        this.horizon = horizon;
        return this;
    }

    public SwitchActionEnum getUpside() {
        return upside;
    }

    public ObstacleAvoidance setUpside(SwitchActionEnum upside) {
        this.upside = upside;
        return this;
    }

    public SwitchActionEnum getDownside() {
        return downside;
    }

    public ObstacleAvoidance setDownside(SwitchActionEnum downside) {
        this.downside = downside;
        return this;
    }
}
