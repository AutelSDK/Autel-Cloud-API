package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.ThermalPaletteStyleEnum;

import java.util.Arrays;

public class DockDroneThermalSupportedPaletteStyle {

    private PayloadIndex payloadIndex;

    private ThermalPaletteStyleEnum[] thermalSupportedPaletteStyles;

    private Integer version;

    public DockDroneThermalSupportedPaletteStyle() {
    }

    @Override
    public String toString() {
        return "DockDroneThermalSupportedPaletteStyle{" +
                "payloadIndex=" + payloadIndex +
                ", thermalSupportedPaletteStyles=" + Arrays.toString(thermalSupportedPaletteStyles) +
                ", version=" + version +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public DockDroneThermalSupportedPaletteStyle setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public ThermalPaletteStyleEnum[] getThermalSupportedPaletteStyles() {
        return thermalSupportedPaletteStyles;
    }

    public DockDroneThermalSupportedPaletteStyle setThermalSupportedPaletteStyles(ThermalPaletteStyleEnum[] thermalSupportedPaletteStyles) {
        this.thermalSupportedPaletteStyles = thermalSupportedPaletteStyles;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public DockDroneThermalSupportedPaletteStyle setVersion(Integer version) {
        this.version = version;
        return this;
    }
}
