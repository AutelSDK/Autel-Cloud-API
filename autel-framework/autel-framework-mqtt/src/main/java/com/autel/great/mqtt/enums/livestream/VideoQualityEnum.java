package com.autel.great.mqtt.enums.livestream;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum VideoQualityEnum {

    AUTO (0),

    SMOOTH(1),

    STANDARD_DEFINITION(2),

    HIGH_DEFINITION(3),

    ULTRA_HD(4);

    private final int quality;

    VideoQualityEnum(int quality) {
        this.quality = quality;
    }

    @JsonValue
    public int getQuality() {
        return quality;
    }

    @JsonCreator
    public static VideoQualityEnum find(int quality) {
        return Arrays.stream(values()).filter(qualityEnum -> qualityEnum.quality == quality).findAny()
                .orElseThrow(() -> new CloudSDKException(VideoQualityEnum.class, quality));
    }
}
