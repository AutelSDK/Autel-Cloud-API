package com.autel.great.mqtt.model.wayline;


import com.autel.great.context.base.BaseModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class FlighttaskResourceGetResponse extends BaseModel {

    /**
     * Wayline file object
     */
    @NotNull
    @Valid
    private FlighttaskFile file;

    public FlighttaskResourceGetResponse() {}

    @Override
    public String toString() {
        return "FlighttaskResourceGetResponse{" +
                "file=" + file +
                '}';
    }

    public FlighttaskFile getFile() {
        return file;
    }

    public FlighttaskResourceGetResponse setFile(FlighttaskFile file) {
        this.file = file;
        return this;
    }
}