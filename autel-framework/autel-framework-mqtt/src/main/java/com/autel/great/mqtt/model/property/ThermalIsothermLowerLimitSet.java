package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.model.device.PayloadIndex;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

public class ThermalIsothermLowerLimitSet extends BaseModel {

    @NotNull
    @Valid
    private PayloadIndex payloadIndex;

    @NotNull
    private Integer thermalIsothermLowerLimit;

    public ThermalIsothermLowerLimitSet() {
    }

    @Override
    public String toString() {
        return "ThermalIsothermLowerLimitSet{" +
                "payloadIndex=" + payloadIndex +
                ", thermalIsothermLowerLimit=" + thermalIsothermLowerLimit +
                '}';
    }

    @JsonValue
    public Map<String, Object> toMap() {
        return Map.of(payloadIndex.toString(), Map.of("thermal_isotherm_upper_limit", thermalIsothermLowerLimit));
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public ThermalIsothermLowerLimitSet setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public Integer getThermalIsothermLowerLimit() {
        return thermalIsothermLowerLimit;
    }

    public ThermalIsothermLowerLimitSet setThermalIsothermLowerLimit(Integer thermalIsothermLowerLimit) {
        this.thermalIsothermLowerLimit = thermalIsothermLowerLimit;
        return this;
    }
}
