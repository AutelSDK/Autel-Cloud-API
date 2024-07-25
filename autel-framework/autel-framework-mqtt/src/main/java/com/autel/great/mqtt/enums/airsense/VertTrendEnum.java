package com.autel.great.mqtt.enums.airsense;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum VertTrendEnum {

    RELATIVE_HEIGHT_UNCHANGED(0),

    RELATIVE_HEIGHT_INCREASE(1),

    RELATIVE_HEIGHT_DECREASE(2),

    ;

    private final int trend;

    VertTrendEnum(int trend) {
        this.trend = trend;
    }

    @JsonValue
    public int getTrend() {
        return trend;
    }

    @JsonCreator
    public static VertTrendEnum find(int trend) {
        return Arrays.stream(values()).filter(trendEnum -> trendEnum.trend == trend).findAny()
            .orElseThrow(() -> new CloudSDKException(VertTrendEnum.class, trend));
    }

}
