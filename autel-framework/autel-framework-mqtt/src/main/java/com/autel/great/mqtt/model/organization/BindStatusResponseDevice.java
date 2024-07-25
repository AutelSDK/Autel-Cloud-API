package com.autel.great.mqtt.model.organization;

public class BindStatusResponseDevice {

    private String sn;

    public BindStatusResponseDevice() {
    }

    @Override
    public String toString() {
        return "BindStatusResponseDevice{" +
                "sn='" + sn + '\'' +
                '}';
    }

    public String getSn() {
        return sn;
    }

    public BindStatusResponseDevice setSn(String sn) {
        this.sn = sn;
        return this;
    }
}
