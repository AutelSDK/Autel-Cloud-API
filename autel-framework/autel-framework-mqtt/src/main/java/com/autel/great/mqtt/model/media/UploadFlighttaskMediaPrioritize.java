package com.autel.great.mqtt.model.media;


import com.autel.great.context.base.BaseModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UploadFlighttaskMediaPrioritize extends BaseModel {

    @NotNull
    @Pattern(regexp = "^[^<>:\"/|?*._\\\\]+$")
    private String flightId;

    public UploadFlighttaskMediaPrioritize() {
    }

    @Override
    public String toString() {
        return "UploadFlighttaskMediaPrioritize{" +
                "flightId='" + flightId + '\'' +
                '}';
    }

    public String getFlightId() {
        return flightId;
    }

    public UploadFlighttaskMediaPrioritize setFlightId(String flightId) {
        this.flightId = flightId;
        return this;
    }
}
