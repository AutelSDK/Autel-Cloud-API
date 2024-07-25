package com.autel.great.mqtt.model.firmware;

public class OtaProgressExt {

    private Long rate;

    public OtaProgressExt() {
    }

    @Override
    public String toString() {
        return "OtaProgressExt{" +
                "rate=" + rate +
                '}';
    }

    public Long getRate() {
        return rate;
    }

    public OtaProgressExt setRate(Long rate) {
        this.rate = rate;
        return this;
    }
}
