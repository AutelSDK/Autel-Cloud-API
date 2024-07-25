package com.autel.great.mqtt.enums.wayline;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum BreakpointStateEnum {

    WAYLINE_SEGMENT(0, "On the wayline segment"),

    WAYPOINT(1, "On the waypoint");

    private final int state;

    private final String msg;

    BreakpointStateEnum(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    @JsonValue
    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    @JsonCreator
    public static BreakpointStateEnum find(int state) {
        return Arrays.stream(values()).filter(stateEnum -> stateEnum.state == state).findAny()
                .orElseThrow(() -> new CloudSDKException(BreakpointStateEnum.class, state));
    }
}
