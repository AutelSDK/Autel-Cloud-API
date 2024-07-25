package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.model.device.PayloadIndex;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;
public class ThermalIsothermUpperLimitSet extends BaseModel {

    @NotNull
    @Valid
    private PayloadIndex payloadIndex;

    @NotNull
    private Integer thermalIsothermUpperLimit;

    public ThermalIsothermUpperLimitSet() {
    }

    @Override
    public String toString() {
        return "ThermalIsothermUpperLimitSet{" +
                "payloadIndex=" + payloadIndex +
                ", thermalIsothermUpperLimit=" + thermalIsothermUpperLimit +
                '}';
    }

    @JsonValue
    public Map<String, Object> toMap() {
        return Map.of(payloadIndex.toString(), Map.of("thermal_isotherm_upper_limit", thermalIsothermUpperLimit));
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public ThermalIsothermUpperLimitSet setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public Integer getThermalIsothermUpperLimit() {
        return thermalIsothermUpperLimit;
    }

    public ThermalIsothermUpperLimitSet setThermalIsothermUpperLimit(Integer thermalIsothermUpperLimit) {
        this.thermalIsothermUpperLimit = thermalIsothermUpperLimit;
        return this;
    }
}
