package com.autel.great.mqtt.enums.firmware;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FirmwareMethodEnum {

    OTA_CREATE("ota_create");

    private final String method;

    FirmwareMethodEnum(String method) {
        this.method = method;
    }

    @JsonValue
    public String getMethod() {
        return method;
    }
}
