package com.autel.great.mqtt.enums.control;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum LensStorageSettingsEnum {

    CURRENT("current"),

    ZOOM("zoom"),

    WIDE("wide"),

    VISION("vision"),

    INFRARED("ir"),
    NIGHTVISION("NightVision");

    private final String lens;

    LensStorageSettingsEnum(String lens) {
        this.lens = lens;
    }

    @JsonValue
    public String getLens() {
        return lens;
    }

    @JsonCreator
    public static LensStorageSettingsEnum find(String lens) {
        return Arrays.stream(values()).filter(lensEnum -> lensEnum.lens.equals(lens)).findAny()
                .orElseThrow(() -> new CloudSDKException(LensStorageSettingsEnum.class, lens));
    }
}
