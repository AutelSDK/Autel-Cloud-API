package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.wayline.RthModeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class DockDroneRthMode extends BaseModel {

    @JsonProperty("rth_mode")
    @NotNull
    private RthModeEnum rthMode;

    public DockDroneRthMode() {
    }

    @Override
    public String toString() {
        return "DockDroneRthMode{" +
                "rthMode=" + rthMode +
                '}';
    }

    public RthModeEnum getRthMode() {
        return rthMode;
    }

    public DockDroneRthMode setRthMode(RthModeEnum rthMode) {
        this.rthMode = rthMode;
        return this;
    }
}
