package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.control.ControlSourceEnum;

public class RcPayloadControlSource {

    private ControlSourceEnum controlSource;

    private PayloadIndex payloadIndex;

    private String sn;

    private String firmwareVersion;

    public RcPayloadControlSource() {
    }

    @Override
    public String toString() {
        return "RcPayloadControlSource{" +
                "controlSource=" + controlSource +
                ", payloadIndex=" + payloadIndex +
                ", sn='" + sn + '\'' +
                ", firmwareVersion='" + firmwareVersion + '\'' +
                '}';
    }

    public ControlSourceEnum getControlSource() {
        return controlSource;
    }

    public RcPayloadControlSource setControlSource(ControlSourceEnum controlSource) {
        this.controlSource = controlSource;
        return this;
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public RcPayloadControlSource setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public String getSn() {
        return sn;
    }

    public RcPayloadControlSource setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public RcPayloadControlSource setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
        return this;
    }
}