package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum SimCardStateEnum {

    NO_CARD(0),

    INSERTED(1),

    ;

    private final int state;

    SimCardStateEnum(int state) {
        this.state = state;
    }

    @JsonValue
    public int getState() {
        return state;
    }

    @JsonCreator
    public static SimCardStateEnum find(int state) {
        return Arrays.stream(values()).filter(stateEnum -> stateEnum.state == state).findAny()
                .orElseThrow(() -> new CloudSDKException(SimCardStateEnum.class, state));
    }

}
