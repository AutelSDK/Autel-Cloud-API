package com.autel.service.manage.model.enums;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ExitWaylineWhenRcLostActionEnum {

    CONTINUE_WAYLINE, EXECUTE_RC_LOST_ACTION;

    @JsonValue
    public int getVal() {
        return ordinal();
    }

    @JsonCreator
    public static ExitWaylineWhenRcLostActionEnum find(int val) {
        return Arrays.stream(values()).filter(lostActionEnum -> lostActionEnum.ordinal() == val).findAny()
                .orElseThrow(() -> new CloudSDKException(ExitWaylineWhenRcLostActionEnum.class, val));
    }
}
