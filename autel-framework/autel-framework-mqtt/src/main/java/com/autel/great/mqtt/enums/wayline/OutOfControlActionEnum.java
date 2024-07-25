package com.autel.great.mqtt.enums.wayline;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum OutOfControlActionEnum {

    RETURN_TO_HOME(0),

    HOVERING(1),

    LANDING(2);

    private final int action;

    OutOfControlActionEnum(int action) {
        this.action = action;
    }

    @JsonValue
    public int getAction() {
        return action;
    }

    @JsonCreator
    public static OutOfControlActionEnum find(int action) {
        return Arrays.stream(values()).filter(actionEnum -> actionEnum.action == action).findAny()
                .orElseThrow(() -> new CloudSDKException(OutOfControlActionEnum.class, action));
    }
}
