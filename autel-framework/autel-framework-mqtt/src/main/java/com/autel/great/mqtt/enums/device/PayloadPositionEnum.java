package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum PayloadPositionEnum {

    FRONT_LEFT(0),

    FRONT_RIGHT(1),

    TOP(2),

    FPV(7);

    private final int position;

    PayloadPositionEnum(int position) {
        this.position = position;
    }

    @JsonValue
    public int getPosition() {
        return position;
    }

    @JsonCreator
    public static PayloadPositionEnum find(int position) {
        return Arrays.stream(values()).filter(positionEnum -> positionEnum.position == position).findAny()
                .orElseThrow(() -> new CloudSDKException(PayloadPositionEnum.class, position));
    }
}
