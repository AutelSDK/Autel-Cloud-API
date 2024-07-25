package com.autel.great.mqtt.enums.wayline;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum FlighttaskStatusEnum {

    SENT("sent", false),

    IN_PROGRESS("in_progress", false),

    OK("ok", true),

    PAUSED("paused", false),

    REJECTED("rejected", true),

    FAILED("failed", true),

    CANCELED("canceled", true),

    TIMEOUT("timeout", true),

    PARTIALLY_DONE("partially_done", true),
    RETURN("return", true),

    PENDING("pending", true);

    private final String status;

    private final boolean end;

    FlighttaskStatusEnum(String status, boolean end) {
        this.status = status;
        this.end = end;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    public boolean isEnd() {
        return end;
    }

    @JsonCreator
    public static FlighttaskStatusEnum find(String status) {
        return Arrays.stream(values()).filter(statusEnum -> statusEnum.status.equals(status)).findAny()
                .orElseThrow(() -> new CloudSDKException(FlighttaskStatusEnum.class, status));
    }
}


