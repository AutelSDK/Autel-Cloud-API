package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum MaintainTypeEnum {

    NO(0),

    DRONE_BASIC(1),

    DRONE_ROUTINE(2),

    DRONE_DEEP(3),

    DOCK_ROUTINE(17),

    DOCK_DEEP(18),
    ;

    private final int type;

    MaintainTypeEnum(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static MaintainTypeEnum find(int type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type == type).findAny()
            .orElseThrow(() -> new CloudSDKException(MaintainTypeEnum.class, type));
    }

}
