package com.autel.great.mqtt.model.wayline;


import com.autel.great.context.base.BaseModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FlighttaskExecuteRequest extends BaseModel {

    @NotNull
    @Pattern(regexp = "^[^<>:\"/|?*._\\\\]+$")
    private String flightId;

    public FlighttaskExecuteRequest() {
    }

    @Override
    public String toString() {
        return "FlighttaskExecuteRequest{" +
                "flightId='" + flightId + '\'' +
                '}';
    }

    public String getFlightId() {
        return flightId;
    }

    public FlighttaskExecuteRequest setFlightId(String flightId) {
        this.flightId = flightId;
        return this;
    }
}
