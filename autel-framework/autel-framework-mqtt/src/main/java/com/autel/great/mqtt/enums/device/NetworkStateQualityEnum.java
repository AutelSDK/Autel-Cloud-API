package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
public enum NetworkStateQualityEnum {

    NO_SIGNAL(0),

    BAD(1),

    POOR(2),

    FAIR(3),

    GOOD(4),

    EXCELLENT(5),
    ;

    private final int quality;

    NetworkStateQualityEnum(int quality) {
        this.quality = quality;
    }

    @JsonValue
    public int getQuality() {
        return quality;
    }

    @JsonCreator
    public static NetworkStateQualityEnum find(int quality) {
        return Arrays.stream(values()).filter(qualityEnum -> qualityEnum.quality == quality).findAny()
            .orElseThrow(() -> new CloudSDKException(NetworkStateQualityEnum.class, quality));
    }

}
