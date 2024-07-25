package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.control.ControlSourceEnum;

public class DockPayloadControlSource {

    private ControlSourceEnum controlSource;

    private PayloadIndex payloadIndex;

    private String sn;

    public DockPayloadControlSource() {
    }

    @Override
    public String toString() {
        return "RcPayloadControlSource{" +
                "controlSource=" + controlSource +
                ", payloadIndex=" + payloadIndex +
                ", sn='" + sn + '\'' +
                '}';
    }

    public ControlSourceEnum getControlSource() {
        return controlSource;
    }

    public DockPayloadControlSource setControlSource(ControlSourceEnum controlSource) {
        this.controlSource = controlSource;
        return this;
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public DockPayloadControlSource setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public String getSn() {
        return sn;
    }

    public DockPayloadControlSource setSn(String sn) {
        this.sn = sn;
        return this;
    }

}