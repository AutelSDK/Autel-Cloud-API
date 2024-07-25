package com.autel.great.mqtt.model.tsa;

import com.autel.great.context.enums.device.DeviceDomainEnum;
import com.autel.great.context.enums.device.DeviceEnum;
import com.autel.great.context.enums.device.DeviceSubTypeEnum;
import com.autel.great.context.enums.device.DeviceTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

@Schema(description = "topology device model")
public class TopologyDeviceModel {

    @NotNull
    @JsonProperty("device_model_key")
    private DeviceEnum deviceModelKey;

    @NotNull
    private DeviceDomainEnum domain;

    @NotNull
    private DeviceTypeEnum type;

    @NotNull
    @JsonProperty("sub_type")
    private DeviceSubTypeEnum subType;

    public TopologyDeviceModel() {
    }

    @Override
    public String toString() {
        return "TopologyDeviceModel{" +
                "deviceModelKey=" + deviceModelKey +
                ", domain=" + domain +
                ", type=" + type +
                ", subType=" + subType +
                '}';
    }

    public DeviceEnum getDeviceModelKey() {
        return deviceModelKey;
    }

    public TopologyDeviceModel setDeviceModelKey(DeviceEnum deviceModelKey) {
        this.deviceModelKey = deviceModelKey;
        return this;
    }

    public DeviceDomainEnum getDomain() {
        return domain;
    }

    public TopologyDeviceModel setDomain(DeviceDomainEnum domain) {
        this.domain = domain;
        return this;
    }

    public DeviceTypeEnum getType() {
        return type;
    }

    public TopologyDeviceModel setType(DeviceTypeEnum type) {
        this.type = type;
        return this;
    }

    public DeviceSubTypeEnum getSubType() {
        return subType;
    }

    public TopologyDeviceModel setSubType(DeviceSubTypeEnum subType) {
        this.subType = subType;
        return this;
    }
}
