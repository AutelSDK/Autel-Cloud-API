package com.autel.great.mqtt.enums.media;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MediaMethodEnum {

    UPLOAD_FLIGHTTASK_MEDIA_PRIORITIZE("upload_flighttask_media_prioritize");

    private final String method;

    MediaMethodEnum(String method) {
        this.method = method;
    }

    @JsonValue
    public String getMethod() {
        return method;
    }
}
