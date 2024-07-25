package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class DockDroneOfflineMapEnable extends BaseModel {

    @JsonProperty("offline_map_enable")
    @NotNull
    private Boolean offlineMapEnable;

    public DockDroneOfflineMapEnable() {
    }

    @Override
    public String toString() {
        return "DockDroneOfflineMapEnable{" +
                "offlineMapEnable=" + offlineMapEnable +
                '}';
    }

    public Boolean getOfflineMapEnable() {
        return offlineMapEnable;
    }

    public DockDroneOfflineMapEnable setOfflineMapEnable(Boolean offlineMapEnable) {
        this.offlineMapEnable = offlineMapEnable;
        return this;
    }
}
