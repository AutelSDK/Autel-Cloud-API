package com.autel.great.mqtt.enums.livestream;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LiveStreamMethodEnum {

    LIVE_START_PUSH("live_start_push"),

    LIVE_STOP_PUSH("live_stop_push"),

    LIVE_SET_QUALITY("live_set_quality"),

    LIVE_LENS_CHANGE("live_lens_change");

    private final String method;

    LiveStreamMethodEnum(String method) {
        this.method = method;
    }

    @JsonValue
    public String getMethod() {
        return method;
    }
}
