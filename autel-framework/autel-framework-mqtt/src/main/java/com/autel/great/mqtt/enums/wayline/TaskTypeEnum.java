package com.autel.great.mqtt.enums.wayline;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum TaskTypeEnum {

    IMMEDIATE(0),

    TIMED(1),

    CONDITIONAL(2);

    private final int type;

    TaskTypeEnum(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return this.type;
    }

    @JsonCreator
    public static TaskTypeEnum find(int type) {
        return Arrays.stream(values()).filter(typeEnum ->  typeEnum.type == type).findAny()
                .orElseThrow(() -> new CloudSDKException(TaskTypeEnum.class, type));
    }
}
