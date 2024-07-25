package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.AirConditionerStateEnum;

public class AirConditioner {

    private AirConditionerStateEnum airConditionerState;

    private Integer switchTime;

    public AirConditioner() {
    }

    @Override
    public String toString() {
        return "AirConditioner{" +
                "airConditionerState=" + airConditionerState +
                ", switchTime=" + switchTime +
                '}';
    }

    public AirConditionerStateEnum getAirConditionerState() {
        return airConditionerState;
    }

    public AirConditioner setAirConditionerState(AirConditionerStateEnum airConditionerState) {
        this.airConditionerState = airConditionerState;
        return this;
    }

    public Integer getSwitchTime() {
        return switchTime;
    }

    public AirConditioner setSwitchTime(Integer switchTime) {
        this.switchTime = switchTime;
        return this;
    }
}
