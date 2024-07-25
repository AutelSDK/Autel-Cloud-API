package com.autel.great.mqtt.enums.flightarea;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum GeofenceTypeEnum {

    DFENCE("dfence"),

    NFZ("nfz"),

    ;

    private final String type;

    GeofenceTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public static GeofenceTypeEnum find(String type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type.equals(type)).findAny()
            .orElseThrow(() -> new CloudSDKException(GeofenceTypeEnum.class, type));
    }
}
