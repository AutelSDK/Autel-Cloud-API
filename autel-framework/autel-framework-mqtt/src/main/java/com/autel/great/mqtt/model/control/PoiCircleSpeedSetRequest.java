package com.autel.great.mqtt.model.control;


import com.autel.great.context.base.BaseModel;

import javax.validation.constraints.NotNull;

public class PoiCircleSpeedSetRequest extends BaseModel {

    @NotNull
    private Float circleSpeed;

    public PoiCircleSpeedSetRequest() {
    }

    @Override
    public String toString() {
        return "PoiCircleSpeedSetRequest{" +
                "circleSpeed=" + circleSpeed +
                '}';
    }

    public Float getCircleSpeed() {
        return circleSpeed;
    }

    public PoiCircleSpeedSetRequest setCircleSpeed(Float circleSpeed) {
        this.circleSpeed = circleSpeed;
        return this;
    }
}
