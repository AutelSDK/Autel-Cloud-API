package com.autel.great.mqtt.model.device;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DockFirmwareVersion {

    private String firmwareVersion;

    @JsonProperty("compatible_status")
    private Boolean needCompatibleStatus;

    private Boolean firmwareUpgradeStatus;

    public DockFirmwareVersion() {
    }

    @Override
    public String toString() {
        return "DockFirmwareVersion{" +
                "firmwareVersion='" + firmwareVersion + '\'' +
                ", compatibleStatus=" + needCompatibleStatus +
                ", firmwareUpgradeStatus=" + firmwareUpgradeStatus +
                '}';
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public DockFirmwareVersion setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
        return this;
    }

    public Boolean getNeedCompatibleStatus() {
        return needCompatibleStatus;
    }

    public DockFirmwareVersion setNeedCompatibleStatus(Boolean needCompatibleStatus) {
        this.needCompatibleStatus = needCompatibleStatus;
        return this;
    }

    public Boolean getFirmwareUpgradeStatus() {
        return firmwareUpgradeStatus;
    }

    public DockFirmwareVersion setFirmwareUpgradeStatus(Boolean firmwareUpgradeStatus) {
        this.firmwareUpgradeStatus = firmwareUpgradeStatus;
        return this;
    }
}
