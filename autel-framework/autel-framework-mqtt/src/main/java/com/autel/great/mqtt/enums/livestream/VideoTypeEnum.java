package com.autel.great.mqtt.enums.livestream;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum VideoTypeEnum {

    ZOOM("zoom"),

    WIDE("wide"),

    THERMAL("thermal"),

    NORMAL("normal"),

    IR("ir");

    private final String type;

    VideoTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public static VideoTypeEnum find(String videoType) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type.equals(videoType)).findAny()
                .orElseThrow(() -> new CloudSDKException(VideoTypeEnum.class , videoType));
    }
}
