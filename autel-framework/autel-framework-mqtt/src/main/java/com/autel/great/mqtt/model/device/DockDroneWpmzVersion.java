package com.autel.great.mqtt.model.device;

public class DockDroneWpmzVersion {

    private String wpmzVersion;

    public DockDroneWpmzVersion() {
    }

    @Override
    public String toString() {
        return "DockDroneWpmzVersion{" +
                "wpmzVersion='" + wpmzVersion + '\'' +
                '}';
    }

    public String getWpmzVersion() {
        return wpmzVersion;
    }

    public DockDroneWpmzVersion setWpmzVersion(String wpmzVersion) {
        this.wpmzVersion = wpmzVersion;
        return this;
    }
}
