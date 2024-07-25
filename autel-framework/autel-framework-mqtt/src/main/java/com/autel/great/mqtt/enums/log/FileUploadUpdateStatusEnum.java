package com.autel.great.mqtt.enums.log;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
public enum FileUploadUpdateStatusEnum {

    CANCEL("cancel");

    private final String status;

    FileUploadUpdateStatusEnum(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static FileUploadUpdateStatusEnum find(String status) {
        return Arrays.stream(values()).filter(statusEnum -> statusEnum.status.equals(status)).findAny()
                .orElseThrow(() -> new CloudSDKException(FileUploadUpdateStatusEnum.class, status));
    }
}
