package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum AirConditionerStateEnum {

    IDLE(0),

    COOL(1),

    HEAT(2),

    DEHUMIDIFICATION(3),

    COOLING_EXIT(4),

    HEATING_EXIT(5),

    DEHUMIDIFICATION_EXIT(6),

    COOLING_PREPARATION(7),

    HEATING_PREPARATION(8),

    DEHUMIDIFICATION_PREPARATION(9),

    DISCONNECTED(32767),
    ;

    private final int state;

    AirConditionerStateEnum(int state) {
        this.state = state;
    }

    @JsonValue
    public int getState() {
        return state;
    }

    @JsonCreator
    public static AirConditionerStateEnum find(int state) {
        return Arrays.stream(values()).filter(stateEnum -> stateEnum.state == state).findAny()
            .orElseThrow(() -> new CloudSDKException(AirConditionerStateEnum.class, state));
    }

}
