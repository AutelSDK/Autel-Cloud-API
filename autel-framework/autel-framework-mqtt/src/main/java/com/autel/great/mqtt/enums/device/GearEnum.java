package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum GearEnum {

    A(0),

    P(1),

    NAV(2),

    FPV(3),

    FARM(4),

    S(5),

    F(6),

    M(7),

    G(8),

    T(9),
    ;

    private final int gear;

    GearEnum(int gear) {
        this.gear = gear;
    }

    @JsonValue
    public int getGear() {
        return gear;
    }

    @JsonCreator
    public static GearEnum find(int gear) {
        return Arrays.stream(values()).filter(gearEnum -> gearEnum.gear == gear).findAny()
            .orElseThrow(() -> new CloudSDKException(GearEnum.class, gear));
    }

}
