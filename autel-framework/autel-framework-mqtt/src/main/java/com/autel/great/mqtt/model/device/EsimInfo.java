package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.TelecomOperatorEnum;

public class EsimInfo {

    private TelecomOperatorEnum telecomOperator;

    private Boolean enabled;

    private String iccid;

    public EsimInfo() {
    }

    @Override
    public String toString() {
        return "EsimInfo{" +
                "telecomOperator=" + telecomOperator +
                ", enabled=" + enabled +
                ", iccid='" + iccid + '\'' +
                '}';
    }

    public TelecomOperatorEnum getTelecomOperator() {
        return telecomOperator;
    }

    public EsimInfo setTelecomOperator(TelecomOperatorEnum telecomOperator) {
        this.telecomOperator = telecomOperator;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public EsimInfo setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getIccid() {
        return iccid;
    }

    public EsimInfo setIccid(String iccid) {
        this.iccid = iccid;
        return this;
    }
}
