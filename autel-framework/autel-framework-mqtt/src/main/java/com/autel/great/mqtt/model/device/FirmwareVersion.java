package com.autel.great.mqtt.model.device;

public class FirmwareVersion {

    private String firmwareVersion;

    public FirmwareVersion() {
    }

    @Override
    public String toString() {
        return "FirmwareVersion{" +
                "firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public FirmwareVersion setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
        return this;
    }

}
