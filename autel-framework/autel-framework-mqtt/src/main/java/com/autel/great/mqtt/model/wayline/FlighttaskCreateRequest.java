package com.autel.great.mqtt.model.wayline;


import com.autel.great.context.base.BaseModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FlighttaskCreateRequest extends BaseModel {

    /**
     * Task ID
     */
    @NotNull
    private String flightId;

    /**
     * Task type
     */
    @NotNull
    @Pattern(regexp = "^wayline$")
    private String type = "wayline";

    /**
     * Wayline flighttaskFile object
     */
    @NotNull
    @Valid
    private FlighttaskCreateFile file;

    public FlighttaskCreateRequest() {}

    @Override
    public String toString() {
        return "FlighttaskCreateRequest{" +
                "flightId='" + flightId + '\'' +
                ", type='" + type + '\'' +
                ", file=" + file +
                '}';
    }

    public String getFlightId() {
        return flightId;
    }

    public FlighttaskCreateRequest setFlightId(String flightId) {
        this.flightId = flightId;
        return this;
    }

    public String getType() {
        return type;
    }

    public FlighttaskCreateRequest setType(String type) {
        this.type = type;
        return this;
    }

    public FlighttaskCreateFile getFile() {
        return file;
    }

    public FlighttaskCreateRequest setFile(FlighttaskCreateFile file) {
        this.file = file;
        return this;
    }
}