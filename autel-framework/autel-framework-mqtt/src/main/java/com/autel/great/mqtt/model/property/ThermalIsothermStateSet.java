package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.device.SwitchActionEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class ThermalIsothermStateSet extends BaseModel {

    @NotNull
    @Valid
    private PayloadIndex payloadIndex;

    @NotNull
    private SwitchActionEnum thermalIsothermState;

    public ThermalIsothermStateSet() {
    }

    @Override
    public String toString() {
        return "ThermalGainModeSet{" +
                "payloadIndex=" + payloadIndex +
                ", thermalIsothermState=" + thermalIsothermState +
                '}';
    }

    @JsonValue
    public Map<String, Object> toMap() {
        return Map.of(payloadIndex.toString(), Map.of("thermal_isotherm_state", thermalIsothermState.getAction()));
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public ThermalIsothermStateSet setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public SwitchActionEnum getThermalIsothermState() {
        return thermalIsothermState;
    }

    public ThermalIsothermStateSet setThermalIsothermState(SwitchActionEnum thermalIsothermState) {
        this.thermalIsothermState = thermalIsothermState;
        return this;
    }
}
