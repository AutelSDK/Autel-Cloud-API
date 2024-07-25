package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.device.ThermalPaletteStyleEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class ThermalCurrentPaletteStyleSet extends BaseModel {

    @NotNull
    @Valid
    private PayloadIndex payloadIndex;

    @NotNull
    private ThermalPaletteStyleEnum thermalCurrentPaletteStyle;

    public ThermalCurrentPaletteStyleSet() {
    }

    @Override
    public String toString() {
        return "ThermalCurrentPaletteStyleSet{" +
                "payloadIndex=" + payloadIndex +
                ", thermalCurrentPaletteStyle=" + thermalCurrentPaletteStyle +
                '}';
    }

    @JsonValue
    public Map<String, Object> toMap() {
        return Map.of(payloadIndex.toString(), Map.of("thermal_current_palette_style", thermalCurrentPaletteStyle.getStyle()));
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public ThermalCurrentPaletteStyleSet setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public ThermalPaletteStyleEnum getThermalCurrentPaletteStyle() {
        return thermalCurrentPaletteStyle;
    }

    public ThermalCurrentPaletteStyleSet setThermalCurrentPaletteStyle(ThermalPaletteStyleEnum thermalCurrentPaletteStyle) {
        this.thermalCurrentPaletteStyle = thermalCurrentPaletteStyle;
        return this;
    }
}
