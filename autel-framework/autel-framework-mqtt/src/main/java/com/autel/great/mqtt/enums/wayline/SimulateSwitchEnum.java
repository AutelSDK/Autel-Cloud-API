package com.autel.great.mqtt.enums.wayline;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
public enum SimulateSwitchEnum {

    DISABLE(0),

    ENABLE(1);

    private final int state;

    SimulateSwitchEnum(int state) {
        this.state = state;
    }

    @JsonValue
    public int getState() {
        return state;
    }

    @JsonCreator
    public static SimulateSwitchEnum find(int state) {
        return Arrays.stream(values()).filter(stateEnum -> stateEnum.state == state).findAny()
            .orElseThrow(() -> new CloudSDKException(SimulateSwitchEnum.class, state));
    }

}
