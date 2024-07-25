package com.autel.great.mqtt.enums.log;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum FileUploadStatusEnum {

    FILE_PULL("file_pull", false),

    FILE_ZIP("file_zip", false),

    FILE_UPLOADING("file_uploading", false),

    SENT("sent", false),

    IN_PROGRESS("in_progress", false),

    OK("ok", true),

    PAUSED("paused", false),

    REJECTED("rejected", true),

    FAILED("failed", true),

    CANCELED("canceled", true),

    TIMEOUT("timeout", true);

    private final String status;

    private final boolean end;

    FileUploadStatusEnum(String status, boolean end) {
        this.status = status;
        this.end = end;
    }

    public boolean isEnd() {
        return end;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static FileUploadStatusEnum find(String status) {
        return Arrays.stream(values()).filter(statusEnum -> statusEnum.status.equals(status)).findAny()
                .orElseThrow(() -> new CloudSDKException(FileUploadStatusEnum.class, status));
    }
}
