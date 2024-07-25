package com.autel.great.mqtt.enums.map;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum OfflineMapSyncStatusEnum {

    WAIT_SYNC("wait_sync"),

    SYNCHRONIZING("synchronizing"),

    SYNCHRONIZED("synchronized"),

    FAIL("fail"),

    SWITCH_FAIL("switch_fail"),

    ;


    private final String status;

    OfflineMapSyncStatusEnum(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static OfflineMapSyncStatusEnum find(String status) {
        return Arrays.stream(values()).filter(statusEnum -> statusEnum.status.equals(status)).findAny()
            .orElseThrow(() -> new CloudSDKException(OfflineMapSyncStatusEnum.class, status));
    }
}
