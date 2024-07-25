package com.autel.great.mqtt.enums.airsense;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum AltitudeTypeEnum {

    ELLIPSOID_HEIGHT(0),

    ABOVE_SEA_LEVEL(1),

    ;

    private final int type;

    AltitudeTypeEnum(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static AltitudeTypeEnum find(int type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type == type).findAny()
            .orElseThrow(() -> new CloudSDKException(AltitudeTypeEnum.class, type));
    }

}
