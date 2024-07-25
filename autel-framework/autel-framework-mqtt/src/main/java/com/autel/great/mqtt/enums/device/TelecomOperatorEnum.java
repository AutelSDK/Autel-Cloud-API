package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum TelecomOperatorEnum {

    UNKNOWN(0),

    CHINA_MOBILE(1),

    CHINA_UNICOM(2),

    CHINA_TELECOM(3),

    ;

    private final int operator;

    TelecomOperatorEnum(int operator) {
        this.operator = operator;
    }

    @JsonValue
    public int getOperator() {
        return operator;
    }

    @JsonCreator
    public static TelecomOperatorEnum find(int operator) {
        return Arrays.stream(values()).filter(operatorEnum -> operatorEnum.operator == operator).findAny()
            .orElseThrow(() -> new CloudSDKException(TelecomOperatorEnum.class, operator));
    }

}
