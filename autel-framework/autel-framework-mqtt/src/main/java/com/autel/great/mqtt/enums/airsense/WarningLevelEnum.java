package com.autel.great.mqtt.enums.airsense;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum WarningLevelEnum {

    ZERO(0),

    ONE(1),

    TWO(2),

    THREE(3),

    FOUR(4),

    ;

    private final int level;

    WarningLevelEnum(int level) {
        this.level = level;
    }

    @JsonValue
    public int getLevel() {
        return level;
    }

    @JsonCreator
    public static WarningLevelEnum find(int level) {
        return Arrays.stream(values()).filter(levelEnum -> levelEnum.level == level).findAny()
            .orElseThrow(() -> new CloudSDKException(WarningLevelEnum.class, level));
    }

}
