package com.autel.great.mqtt.enums.control;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ExposureModeEnum {

    AUTO(1),

    SHUTTER_PRIORITY(2),

    APERTURE_PRIORITY(3),

    MANUAL(4),

    ;


    private final int mode;

    ExposureModeEnum(int mode) {
        this.mode = mode;
    }

    @JsonValue
    public int getMode() {
        return mode;
    }

    @JsonCreator
    public static ExposureModeEnum find(int mode) {
        return Arrays.stream(values()).filter(modeEnum -> modeEnum.mode == mode).findAny()
            .orElseThrow(() -> new CloudSDKException(ExposureModeEnum.class, mode));
    }

}
