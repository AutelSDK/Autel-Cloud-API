package com.autel.great.mqtt.enums.control;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum PhotoTakeProgressStepEnum {

    NORMAL(0),

    PANORAMA_NOT_STARTED_OR_ENDED(3000),

    PANORAMA_TAKING(3002),

    PANORAMA_COMPOSITING(3005),

    ;

    private final int step;

    PhotoTakeProgressStepEnum(int step) {
        this.step = step;
    }

    @JsonValue
    public int getStep() {
        return step;
    }

    @JsonCreator
    public static PhotoTakeProgressStepEnum find(int step) {
        return Arrays.stream(values()).filter(stepEnum -> stepEnum.step == step).findAny()
            .orElseThrow(() -> new CloudSDKException(PhotoTakeProgressStepEnum.class, step));
    }

}
