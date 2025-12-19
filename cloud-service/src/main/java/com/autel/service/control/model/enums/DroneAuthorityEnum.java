package com.autel.service.control.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;


public enum DroneAuthorityEnum {

    FLIGHT(1), PAYLOAD(2);

    int val;

    DroneAuthorityEnum(int val) {
        this.val = val;
    }

    @JsonValue
    public int getVal() {
        return val;
    }

}
