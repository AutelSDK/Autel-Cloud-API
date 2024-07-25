package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum BatteryStoreModeEnum {

    PLAN(1),

    EMERGENCY(2);

    private final int mode;

    BatteryStoreModeEnum(int mode) {
        this.mode = mode;
    }

    @JsonValue
    public int getMode() {
        return mode;
    }

    @JsonCreator
    public static BatteryStoreModeEnum find(int mode) {
        return Arrays.stream(BatteryStoreModeEnum.values()).filter(modeEnum -> modeEnum.mode == mode).findAny()
                .orElseThrow(() -> new CloudSDKException(BatteryStoreModeEnum.class, mode));
    }
}
