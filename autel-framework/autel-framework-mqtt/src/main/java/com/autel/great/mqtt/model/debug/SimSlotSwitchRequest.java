package com.autel.great.mqtt.model.debug;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.debug.DongleDeviceTypeEnum;
import com.autel.great.mqtt.enums.device.SimSlotEnum;

import javax.validation.constraints.NotNull;

public class SimSlotSwitchRequest extends BaseModel {

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

    /**
     * Switch between using physical sim card and using esim.
     */
    @NotNull
    private SimSlotEnum simSlot;

    public SimSlotSwitchRequest() {
    }

    @Override
    public String toString() {
        return "SimSlotSwitchRequest{" +
                "imei='" + imei + '\'' +
                ", deviceType=" + deviceType +
                ", simSlot=" + simSlot +
                '}';
    }

    public String getImei() {
        return imei;
    }

    public SimSlotSwitchRequest setImei(String imei) {
        this.imei = imei;
        return this;
    }

    public DongleDeviceTypeEnum getDeviceType() {
        return deviceType;
    }

    public SimSlotSwitchRequest setDeviceType(DongleDeviceTypeEnum deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public SimSlotEnum getSimSlot() {
        return simSlot;
    }

    public SimSlotSwitchRequest setSimSlot(SimSlotEnum simSlot) {
        this.simSlot = simSlot;
        return this;
    }
}
