package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.control.ControlSourceEnum;

import java.util.List;

public class RcDroneControlSource {

    private ControlSourceEnum controlSource;

    private Float homeLatitude;

    private Float homeLongitude;

    private Integer lowBatteryWarningThreshold;

    private Integer seriousLowBatteryWarningThreshold;

    private List<RcPayloadControlSource> payloads;

    public RcDroneControlSource() {
    }

    @Override
    public String toString() {
        return "RcDroneControlSource{" +
                "controlSource=" + controlSource +
                ", homeLatitude=" + homeLatitude +
                ", homeLongitude=" + homeLongitude +
                ", lowBatteryWarningThreshold=" + lowBatteryWarningThreshold +
                ", seriousLowBatteryWarningThreshold=" + seriousLowBatteryWarningThreshold +
                ", payloads=" + payloads +
                '}';
    }

    public ControlSourceEnum getControlSource() {
        return controlSource;
    }

    public RcDroneControlSource setControlSource(ControlSourceEnum controlSource) {
        this.controlSource = controlSource;
        return this;
    }

    public Float getHomeLatitude() {
        return homeLatitude;
    }

    public RcDroneControlSource setHomeLatitude(Float homeLatitude) {
        this.homeLatitude = homeLatitude;
        return this;
    }

    public Float getHomeLongitude() {
        return homeLongitude;
    }

    public RcDroneControlSource setHomeLongitude(Float homeLongitude) {
        this.homeLongitude = homeLongitude;
        return this;
    }

    public Integer getLowBatteryWarningThreshold() {
        return lowBatteryWarningThreshold;
    }

    public RcDroneControlSource setLowBatteryWarningThreshold(Integer lowBatteryWarningThreshold) {
        this.lowBatteryWarningThreshold = lowBatteryWarningThreshold;
        return this;
    }

    public Integer getSeriousLowBatteryWarningThreshold() {
        return seriousLowBatteryWarningThreshold;
    }

    public RcDroneControlSource setSeriousLowBatteryWarningThreshold(Integer seriousLowBatteryWarningThreshold) {
        this.seriousLowBatteryWarningThreshold = seriousLowBatteryWarningThreshold;
        return this;
    }

    public List<RcPayloadControlSource> getPayloads() {
        return payloads;
    }

    public RcDroneControlSource setPayloads(List<RcPayloadControlSource> payloads) {
        this.payloads = payloads;
        return this;
    }
}