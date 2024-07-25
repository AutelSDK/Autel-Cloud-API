package com.autel.great.mqtt.enums.hms;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum HmsLevelEnum {

    INFORM(0),

    NOTICE(1),

    ALARM(2);

    private final int level;

    HmsLevelEnum(int level) {
        this.level = level;
    }

    @JsonValue
    public int getLevel() {
        return level;
    }

    @JsonCreator
    public static HmsLevelEnum find(int level) {
        return Arrays.stream(values()).filter(levelEnum -> levelEnum.level == level).findAny()
                .orElseThrow(() -> new CloudSDKException(HmsLevelEnum.class, level));
    }
}
