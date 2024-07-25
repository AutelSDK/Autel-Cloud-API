package com.autel.great.mqtt.enums.wayline;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum OrderByColumnEnum {

    NAME("name"),

    UPDATE_TIME("update_time"),

    CREATE_TIME("create_time"),

    ;

    private final String column;

    OrderByColumnEnum(String column) {
        this.column = column;
    }

    @JsonValue
    public String getColumn() {
        return column;
    }

    @JsonCreator
    public static OrderByColumnEnum find(String column) {
        return Arrays.stream(values()).filter(columnEnum -> columnEnum.column.equals(column)).findAny()
            .orElseThrow(() -> new CloudSDKException(OrderByColumnEnum.class, column));
    }
}
