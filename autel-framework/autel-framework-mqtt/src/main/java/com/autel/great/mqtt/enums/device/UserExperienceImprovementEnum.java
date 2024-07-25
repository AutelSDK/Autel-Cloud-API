package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum UserExperienceImprovementEnum {

    INITIAL(0),

    REFUSE(1),

    AGREE(2),
    ;

    private final int state;

    UserExperienceImprovementEnum(int state) {
        this.state = state;
    }

    @JsonValue
    public int getState() {
        return state;
    }

    @JsonCreator
    public static UserExperienceImprovementEnum find(int state) {
        return Arrays.stream(values()).filter(stateEnum -> stateEnum.state == state).findAny()
            .orElseThrow(() -> new CloudSDKException(UserExperienceImprovementEnum.class, state));
    }

}
