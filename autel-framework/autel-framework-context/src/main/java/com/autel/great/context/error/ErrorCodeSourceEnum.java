
package com.autel.great.context.error;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ErrorCodeSourceEnum {
    DEVICE(3),

    DOCK(5),

    PILOT(6);

    private final int source;

    ErrorCodeSourceEnum(int source) {
        this.source = source;
    }

    @JsonValue
    public int getSource() {
        return source;
    }

    @JsonCreator
    public static ErrorCodeSourceEnum find(int source) {
        return Arrays.stream(values()).filter(error -> error.source == source).findAny()
                .orElseThrow(() -> new CloudSDKException(ErrorCodeSourceEnum.class, source));
    }
}
