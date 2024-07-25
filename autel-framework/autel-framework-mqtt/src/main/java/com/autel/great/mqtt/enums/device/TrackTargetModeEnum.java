package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum TrackTargetModeEnum {

    NORMAL(1),

    LOW_CREDIBILITY(2),

    PREDICTED(3),
    ;
    private final int mode;

    TrackTargetModeEnum(int mode) {
        this.mode = mode;
    }

    @JsonValue
    public int getMode() {
        return mode;
    }

    @JsonCreator
    public static TrackTargetModeEnum find(int mode) {
        return Arrays.stream(values()).filter(modeEnum -> modeEnum.mode == mode).findAny()
            .orElseThrow(() -> new CloudSDKException(TrackTargetModeEnum.class, mode));
    }

}
