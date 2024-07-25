package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum FocusStateEnum {

    IDLE(0),

    FOCUSING(1),

    SUCCESS(2),

    FAILED(3),

    ;

    private final int state;

    FocusStateEnum(int state) {
        this.state = state;
    }

    @JsonValue
    public int getState() {
        return state;
    }

    @JsonCreator
    public static FocusStateEnum find(int state) {
        return Arrays.stream(values()).filter(stateEnum -> stateEnum.state == state).findAny()
            .orElseThrow(() -> new CloudSDKException(FocusStateEnum.class, state));
    }

}
