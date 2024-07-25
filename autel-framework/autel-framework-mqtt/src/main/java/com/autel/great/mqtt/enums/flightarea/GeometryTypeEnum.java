package com.autel.great.mqtt.enums.flightarea;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum GeometryTypeEnum {

    POINT("Point"),

    POLYGON("Polygon"),

    ;

    private final String type;

    GeometryTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public static GeometryTypeEnum find(String type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type.equals(type)).findAny()
            .orElseThrow(() -> new CloudSDKException(GeometryTypeEnum.class, type));
    }
}
