package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum DongleTypeEnum {

    OLD_DONGLE(6),

    SUPPORTED_ESIM(10),

    ;

    private final int type;

    DongleTypeEnum(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static DongleTypeEnum find(int type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type == type).findAny()
            .orElseThrow(() -> new CloudSDKException(DongleTypeEnum.class, type));
    }

}
