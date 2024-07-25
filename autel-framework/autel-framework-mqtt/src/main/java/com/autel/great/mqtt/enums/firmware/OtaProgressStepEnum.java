package com.autel.great.mqtt.enums.firmware;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum OtaProgressStepEnum {

    DOWNLOADING(1),

    UPGRADING(2);

    private final int step;

    OtaProgressStepEnum(int step) {
        this.step = step;
    }

    @JsonValue
    public int getStep() {
        return step;
    }

    @JsonCreator
    public static OtaProgressStepEnum find(int step) {
        return Arrays.stream(values()).filter(stepEnum -> stepEnum.step == step).findAny()
                .orElseThrow(() -> new CloudSDKException(OtaProgressStepEnum.class, step));
    }
}
