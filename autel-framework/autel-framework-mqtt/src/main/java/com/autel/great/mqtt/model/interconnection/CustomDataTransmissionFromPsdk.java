package com.autel.great.mqtt.model.interconnection;

public class CustomDataTransmissionFromPsdk {
    private String value;

    public CustomDataTransmissionFromPsdk() {
    }

    @Override
    public String toString() {
        return "CustomDataTransmissionFromPsdk{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public CustomDataTransmissionFromPsdk setValue(String value) {
        this.value = value;
        return this;
    }
}
