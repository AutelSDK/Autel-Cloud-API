package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum BatteryIndexEnum {

    LEFT(0),

    RIGHT(1);

    private final int index;

    BatteryIndexEnum(int index) {
        this.index = index;
    }

    @JsonValue
    public int getIndex() {
        return index;
    }

    @JsonCreator
    public static BatteryIndexEnum find(int index) {
        return Arrays.stream(values()).filter(indexEnum -> indexEnum.index == index).findAny()
            .orElseThrow(() -> new CloudSDKException(BatteryIndexEnum.class, index));
    }

}
