package com.autel.service.media.model;

import lombok.Getter;

@Getter
public enum MediaMethodEnum {

    UPLOAD_FLIGHT_TASK_MEDIA_PRIORITIZE("upload_flighttask_media_prioritize");

    private String method;

    MediaMethodEnum(String method) {
        this.method = method;
    }
}
