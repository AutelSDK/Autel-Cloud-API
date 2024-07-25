package com.autel.great.mqtt.enums.control;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
public enum CommanderModeLostActionEnum {

    CONTINUE(0),

    EXECUTE_RC_LOST_ACTION(1);

    private final int action;

    CommanderModeLostActionEnum(int action) {
        this.action = action;
    }

    @JsonValue
    public int getAction() {
        return action;
    }

    @JsonCreator
    public static CommanderModeLostActionEnum find(int action) {
        return Arrays.stream(values()).filter(actionEnum -> actionEnum.action == action).findAny()
                .orElseThrow(() -> new CloudSDKException(CommanderModeLostActionEnum.class, action));
    }
}
