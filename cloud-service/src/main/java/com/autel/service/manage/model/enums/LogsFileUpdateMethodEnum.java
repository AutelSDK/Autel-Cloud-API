package com.autel.service.manage.model.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum LogsFileUpdateMethodEnum {

    CANCEL("cancel"),

    UNKNOWN("unknown");

    String method;

    LogsFileUpdateMethodEnum(String method) {
        this.method = method;
    }

    public static LogsFileUpdateMethodEnum find(String method) {
        return Arrays.stream(LogsFileUpdateMethodEnum.values()).filter(e -> e.method.equals(method)).findAny().orElse(UNKNOWN);
    }
}
