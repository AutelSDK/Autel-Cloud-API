package com.autel.great.mqtt.enums.wayline;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ActionTypeEnum {

    SPOT_CHECK(1),

    ;

    private final int type;

    ActionTypeEnum(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static ActionTypeEnum find(int type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type == type).findAny()
            .orElseThrow(() -> new CloudSDKException(ActionTypeEnum.class, type));
    }

}
