package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum MeasureTargetStateEnum {

    NORMAL(0),

    TOO_CLOSE(1),

    TOO_FAR(2),

    NO_SIGNAL(3),
    ;

    private final int state;

    MeasureTargetStateEnum(int state) {
        this.state = state;
    }

    @JsonValue
    public int getState() {
        return state;
    }

    @JsonCreator
    public static MeasureTargetStateEnum find(int state) {
        return Arrays.stream(values()).filter(stateEnum -> stateEnum.state == state).findAny()
            .orElseThrow(() -> new CloudSDKException(MeasureTargetStateEnum.class, state));
    }

}
