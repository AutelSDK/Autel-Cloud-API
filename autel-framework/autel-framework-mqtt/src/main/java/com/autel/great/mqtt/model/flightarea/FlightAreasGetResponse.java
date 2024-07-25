package com.autel.great.mqtt.model.flightarea;


import com.autel.great.context.base.BaseModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FlightAreasGetResponse extends BaseModel {

    /**
     * File list
     */
    @NotNull
    private List<@Valid FlightAreaGetFile> files;

    public FlightAreasGetResponse() {
    }

    @Override
    public String toString() {
        return "FlightAreasGetResponse{" +
                "files=" + files +
                '}';
    }

    public List<FlightAreaGetFile> getFiles() {
        return files;
    }

    public FlightAreasGetResponse setFiles(List<FlightAreaGetFile> files) {
        this.files = files;
        return this;
    }
}
