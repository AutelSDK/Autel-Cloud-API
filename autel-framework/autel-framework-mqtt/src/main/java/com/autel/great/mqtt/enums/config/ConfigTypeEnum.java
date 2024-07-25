package com.autel.great.mqtt.enums.config;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ConfigTypeEnum {

    JSON("json");

    private final String type;

    ConfigTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public static ConfigTypeEnum find(String type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type.equals(type)).findAny()
                .orElseThrow(() -> new CloudSDKException(ConfigTypeEnum.class, type));
    }
}
