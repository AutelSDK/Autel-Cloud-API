package com.autel.great.mqtt.model.debug;


import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.debug.DongleDeviceTypeEnum;

import javax.validation.constraints.NotNull;

public class EsimActivateRequest extends BaseModel {

    /**
     * Identifies the dongle to be operated on.
     */
    @NotNull
    private String imei;

    /**
     * Identifies the target device to operate on.
     */
    @NotNull
    private DongleDeviceTypeEnum deviceType;

    public EsimActivateRequest() {
    }

    @Override
    public String toString() {
        return "EsimActivateRequest{" +
                "imei='" + imei + '\'' +
                ", deviceType=" + deviceType +
                '}';
    }

    public String getImei() {
        return imei;
    }

    public EsimActivateRequest setImei(String imei) {
        this.imei = imei;
        return this;
    }

    public DongleDeviceTypeEnum getDeviceType() {
        return deviceType;
    }

    public EsimActivateRequest setDeviceType(DongleDeviceTypeEnum deviceType) {
        this.deviceType = deviceType;
        return this;
    }
}
