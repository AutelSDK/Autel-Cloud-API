package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum RcLostActionEnum {

    HOVER(0),

    LAND(1),

    RETURN_HOME(2);

    private final int action;

    RcLostActionEnum(int action) {
        this.action = action;
    }

    @JsonValue
    public int getAction() {
        return action;
    }

    @JsonCreator
    public static RcLostActionEnum find(int action) {
        return Arrays.stream(values()).filter(actionEnum -> actionEnum.ordinal() == action).findAny()
                .orElseThrow(() -> new CloudSDKException(RcLostActionEnum.class, action));
    }
}
