package com.autel.great.mqtt.enums.livestream;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum LensChangeVideoTypeEnum {

    ZOOM("zoom"),

    WIDE("wide"),

    IR("ir");

    private final String type;

    LensChangeVideoTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public static LensChangeVideoTypeEnum find(String videoType) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type.equals(videoType)).findAny()
                .orElseThrow(() -> new CloudSDKException(LensChangeVideoTypeEnum.class , videoType));
    }
}
