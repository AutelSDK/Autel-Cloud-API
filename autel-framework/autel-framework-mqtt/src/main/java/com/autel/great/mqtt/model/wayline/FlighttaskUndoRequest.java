package com.autel.great.mqtt.model.wayline;


import com.autel.great.context.base.BaseModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class FlighttaskUndoRequest extends BaseModel {

    @NotNull
    @Size(min = 1)
    private List<@Pattern(regexp = "^[^<>:\"/|?*._\\\\]+$") String> flightIds;

    public FlighttaskUndoRequest() {
    }

    @Override
    public String toString() {
        return "FlighttaskUndoRequest{" +
                "flightIds=" + flightIds +
                '}';
    }

    public List<String> getFlightIds() {
        return flightIds;
    }

    public FlighttaskUndoRequest setFlightIds(List<String> flightIds) {
        this.flightIds = flightIds;
        return this;
    }
}
