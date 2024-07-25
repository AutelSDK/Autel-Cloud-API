package com.autel.great.mqtt.model.organization;

import com.autel.great.mqtt.core.consume.MqttReply;

import javax.validation.constraints.NotNull;

public class OrganizationBindInfo {

    @NotNull
    private String sn;

    @NotNull
    private Integer errCode;

    public OrganizationBindInfo() {
    }

    public OrganizationBindInfo(String sn, Integer errCode) {
        this.sn = sn;
        this.errCode = errCode;
    }

    public static OrganizationBindInfo success(String sn) {
        return new OrganizationBindInfo(sn, MqttReply.CODE_SUCCESS);
    }

    @Override
    public String toString() {
        return "OrganizationBindInfo{" +
                "sn='" + sn + '\'' +
                ", errCode=" + errCode +
                '}';
    }

    public String getSn() {
        return sn;
    }

    public OrganizationBindInfo setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public OrganizationBindInfo setErrCode(Integer errCode) {
        this.errCode = errCode;
        return this;
    }
}
