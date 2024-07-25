package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.SimTypeEnum;
import com.autel.great.mqtt.enums.device.TelecomOperatorEnum;

public class SimInfo {

    private TelecomOperatorEnum telecomOperator;

    private SimTypeEnum simType;
    private String iccid;

    public SimInfo() {
    }

    @Override
    public String toString() {
        return "SimInfo{" +
                "telecomOperator=" + telecomOperator +
                ", simType=" + simType +
                ", iccid='" + iccid + '\'' +
                '}';
    }

    public TelecomOperatorEnum getTelecomOperator() {
        return telecomOperator;
    }

    public SimInfo setTelecomOperator(TelecomOperatorEnum telecomOperator) {
        this.telecomOperator = telecomOperator;
        return this;
    }

    public SimTypeEnum getSimType() {
        return simType;
    }

    public SimInfo setSimType(SimTypeEnum simType) {
        this.simType = simType;
        return this;
    }

    public String getIccid() {
        return iccid;
    }

    public SimInfo setIccid(String iccid) {
        this.iccid = iccid;
        return this;
    }
}
