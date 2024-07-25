package com.autel.great.mqtt.enums.control;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ExposureCameraTypeEnum {

    ZOOM("zoom"),

    WIDE("wide");

    private final String type;

    ExposureCameraTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public static ExposureCameraTypeEnum find(String type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type.equals(type)).findAny()
                .orElseThrow(() -> new CloudSDKException(ExposureCameraTypeEnum.class, type));
    }
}
