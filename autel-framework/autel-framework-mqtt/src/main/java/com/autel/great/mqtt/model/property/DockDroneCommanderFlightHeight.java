package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DockDroneCommanderFlightHeight extends BaseModel {

    @JsonProperty("commander_flight_height")
    @NotNull
    @Min(2)
    @Max(3000)
    private Float commanderFlightHeight;

    public DockDroneCommanderFlightHeight() {
    }

    @Override
    public String toString() {
        return "DockDroneCommanderFlightHeight{" +
                "commanderFlightHeight=" + commanderFlightHeight +
                '}';
    }

    public Float getCommanderFlightHeight() {
        return commanderFlightHeight;
    }

    public DockDroneCommanderFlightHeight setCommanderFlightHeight(Float commanderFlightHeight) {
        this.commanderFlightHeight = commanderFlightHeight;
        return this;
    }
}
