package com.autel.great.mqtt.enums.control;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ZoomCameraTypeEnum {

    ZOOM("zoom"),

    IR("ir");

    private final String type;

    ZoomCameraTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public static ZoomCameraTypeEnum find(String type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type.equals(type)).findAny()
                .orElseThrow(() -> new CloudSDKException(ZoomCameraTypeEnum.class, type));
    }
}
