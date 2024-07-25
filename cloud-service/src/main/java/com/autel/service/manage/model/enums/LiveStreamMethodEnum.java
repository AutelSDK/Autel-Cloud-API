package com.autel.service.manage.model.enums;

import lombok.Getter;

@Getter
public enum LiveStreamMethodEnum {

    LIVE_START_PUSH("live_start_push"),

    LIVE_STOP_PUSH("live_stop_push"),

    LIVE_SET_QUALITY("live_set_quality"),

    LIVE_LENS_CHANGE("live_lens_change"),

    UNKNOWN("unknown");

    private String method;

    LiveStreamMethodEnum(String method) {
        this.method = method;
    }

}
