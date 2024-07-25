package com.autel.great.mqtt.enums.debug;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum DongleDeviceTypeEnum {

    DOCK("dock"),

    DRONE("drone"),

    ;

    private final String type;

    DongleDeviceTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public static DongleDeviceTypeEnum find(String type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type.equals(type)).findAny()
            .orElseThrow(() -> new CloudSDKException(DongleDeviceTypeEnum.class, type));
    }
}
