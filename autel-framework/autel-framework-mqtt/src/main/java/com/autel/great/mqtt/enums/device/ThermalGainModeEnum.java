package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ThermalGainModeEnum {

    AUTOMATIC(0),

    LOW(1),

    HIGH(2),
    ;

    private final int mode;

    ThermalGainModeEnum(int mode) {
        this.mode = mode;
    }

    @JsonValue
    public int getMode() {
        return mode;
    }

    @JsonCreator
    public static ThermalGainModeEnum find(int mode) {
        return Arrays.stream(values()).filter(modeEnum -> modeEnum.mode == mode).findAny()
            .orElseThrow(() -> new CloudSDKException(ThermalGainModeEnum.class, mode));
    }

}
