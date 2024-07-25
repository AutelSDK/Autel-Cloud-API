package com.autel.service.wayline.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WaylineTaskStatusEnum {

    PAUSE, RESUME;

    @JsonValue
    public int getVal() {
        return ordinal();
    }

}
