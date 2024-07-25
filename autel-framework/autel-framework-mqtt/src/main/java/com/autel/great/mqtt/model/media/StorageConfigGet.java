package com.autel.great.mqtt.model.media;

import com.autel.great.mqtt.enums.media.StorageConfigGetModuleEnum;

public class StorageConfigGet {

    private StorageConfigGetModuleEnum module;

    public StorageConfigGet() {
    }

    @Override
    public String toString() {
        return "StorageConfigGet{" +
                "module=" + module +
                '}';
    }

    public StorageConfigGetModuleEnum getModule() {
        return module;
    }

    public StorageConfigGet setModule(StorageConfigGetModuleEnum module) {
        this.module = module;
        return this;
    }
}
