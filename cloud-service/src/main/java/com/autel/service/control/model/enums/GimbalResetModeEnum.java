package com.autel.service.control.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;


public enum GimbalResetModeEnum {

    RECENTER, DOWN, RECENTER_PAN, PITCH_DOWN;

    @JsonValue
    public int getVal() {
        return ordinal();
    }

    @JsonCreator
    public static GimbalResetModeEnum find(int value) {
        return Arrays.stream(values()).filter(resetModeEnum -> resetModeEnum.ordinal() == value).findAny().get();
    }
}
