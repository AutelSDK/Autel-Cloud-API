package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum FlighttaskStepCodeEnum {

    TASK_PREPARING(0),

    TASK_OPERATING(1),

    STATE_RECOVERING(2),

    CUSTOM_FLIGHT_AREA_UPDATING(3),

    OFFLINE_MAP_UPDATING(4),

    IDLE(5),

    UNKNOWN1(255),

    UNKNOWN2(256),
    ;

    private final int code;

    FlighttaskStepCodeEnum(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static FlighttaskStepCodeEnum find(int code) {
        return Arrays.stream(values()).filter(codeEnum -> codeEnum.code == code).findAny()
            .orElseThrow(() -> new CloudSDKException(FlighttaskStepCodeEnum.class, code));
    }

}
