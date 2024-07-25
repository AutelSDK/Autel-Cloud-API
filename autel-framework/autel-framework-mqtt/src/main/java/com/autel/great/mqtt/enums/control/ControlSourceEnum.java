package com.autel.great.mqtt.enums.control;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ControlSourceEnum {

    A("A"),

    B("B"),

    UNKNOWN("");

    private final String controlSource;

    ControlSourceEnum(String controlSource) {
        this.controlSource = controlSource;
    }

    @JsonValue
    public String getControlSource() {
        return controlSource;
    }

    @JsonCreator
    public static ControlSourceEnum find(String controlSource) {
        return Arrays.stream(values()).filter(controlSourceEnum -> controlSourceEnum.controlSource.equals(controlSource)).findAny()
                .orElseThrow(() -> new CloudSDKException(ControlSourceEnum.class, controlSource));
    }
}
