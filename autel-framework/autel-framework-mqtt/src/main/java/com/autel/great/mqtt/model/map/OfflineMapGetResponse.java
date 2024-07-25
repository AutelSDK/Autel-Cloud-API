package com.autel.great.mqtt.model.map;


import com.autel.great.context.base.BaseModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
public class OfflineMapGetResponse extends BaseModel {

    /**
     * This parameter allows the dock to turn off the offline map capability of the aircraft.
     */
    @NotNull
    private Boolean offlineMapEnable;

    /**
     * Offline map file object list.
     */
    @NotNull
    private List<@Valid OfflineMapFile> files;

    public OfflineMapGetResponse() {
    }

    @Override
    public String toString() {
        return "OfflineMapGetResponse{" +
                "offlineMapEnable=" + offlineMapEnable +
                ", files=" + files +
                '}';
    }

    public Boolean getOfflineMapEnable() {
        return offlineMapEnable;
    }

    public OfflineMapGetResponse setOfflineMapEnable(Boolean offlineMapEnable) {
        this.offlineMapEnable = offlineMapEnable;
        return this;
    }

    public List<OfflineMapFile> getFiles() {
        return files;
    }

    public OfflineMapGetResponse setFiles(List<OfflineMapFile> files) {
        this.files = files;
        return this;
    }
}
