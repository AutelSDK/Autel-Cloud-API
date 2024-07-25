package com.autel.great.mqtt.model.interconnection;

public class CustomDataTransmissionFromEsdk {
    private String value;

    public CustomDataTransmissionFromEsdk() {
    }

    @Override
    public String toString() {
        return "CustomDataTransmissionFromEsdk{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public CustomDataTransmissionFromEsdk setValue(String value) {
        this.value = value;
        return this;
    }
}
