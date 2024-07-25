package com.autel.great.mqtt.enums.flightarea;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum GeometrySubTypeEnum {

    CIRCLE("Circle"),

    ;

    private final String subType;

    GeometrySubTypeEnum(String subType) {
        this.subType = subType;
    }

    @JsonValue
    public String getSubType() {
        return subType;
    }

    @JsonCreator
    public static GeometrySubTypeEnum find(String subType) {
        return Arrays.stream(values()).filter(subTypeEnum -> subTypeEnum.subType.equals(subType)).findAny()
            .orElseThrow(() -> new CloudSDKException(GeometrySubTypeEnum.class, subType));
    }
}
