package com.autel.great.mqtt.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum SimSlotEnum {

    UNKNOWN(0),

    SIM(1),

    ESIM(2),

    ;

    private final int slot;

    SimSlotEnum(int slot) {
        this.slot = slot;
    }

    @JsonValue
    public int getSlot() {
        return slot;
    }

    @JsonCreator
    public static SimSlotEnum find(int slot) {
        return Arrays.stream(values()).filter(slotEnum -> slotEnum.slot == slot).findAny()
            .orElseThrow(() -> new CloudSDKException(SimSlotEnum.class, slot));
    }

}
