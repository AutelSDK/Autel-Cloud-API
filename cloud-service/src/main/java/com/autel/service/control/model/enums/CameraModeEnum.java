package com.autel.service.control.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum CameraModeEnum {

    PHOTO, VIDEO;

    @JsonValue
    public int getVal() {
        return ordinal();
    }

    @JsonCreator
    public static CameraModeEnum find(int val) {
        return Arrays.stream(values()).filter(modeEnum -> modeEnum.ordinal() == val).findAny().get();
    }
}
