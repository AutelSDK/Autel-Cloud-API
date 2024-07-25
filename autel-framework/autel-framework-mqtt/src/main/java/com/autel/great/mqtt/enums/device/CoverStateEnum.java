package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum CoverStateEnum {

    CLOSED(0),

    OPENED(1),

    HALF_OPEN(2),

    ABNORMAL(3),
    ;

    private final int state;

    CoverStateEnum(int state) {
        this.state = state;
    }

    @JsonValue
    public int getState() {
        return state;
    }

    @JsonCreator
    public static CoverStateEnum find(int state) {
        return Arrays.stream(values()).filter(stateEnum -> stateEnum.state == state).findAny()
            .orElseThrow(() -> new CloudSDKException(CoverStateEnum.class, state));
    }

}
