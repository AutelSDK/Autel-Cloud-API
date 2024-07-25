package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.device.ThermalGainModeEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class ThermalGainModeSet extends BaseModel {

    @NotNull
    @Valid
    private PayloadIndex payloadIndex;

    @NotNull
    private ThermalGainModeEnum thermalGainMode;

    public ThermalGainModeSet() {
    }

    @Override
    public String toString() {
        return "ThermalGainModeSet{" +
                "payloadIndex=" + payloadIndex +
                ", thermalGainMode=" + thermalGainMode +
                '}';
    }

    @JsonValue
    public Map<String, Object> toMap() {
        return Map.of(payloadIndex.toString(), Map.of("thermal_gain_mode", thermalGainMode.getMode()));
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public ThermalGainModeSet setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public ThermalGainModeEnum getThermalGainMode() {
        return thermalGainMode;
    }

    public ThermalGainModeSet setThermalGainMode(ThermalGainModeEnum thermalGainMode) {
        this.thermalGainMode = thermalGainMode;
        return this;
    }
}
