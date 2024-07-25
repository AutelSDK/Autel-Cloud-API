package com.autel.great.mqtt.enums.firmware;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum FirmwareUpgradeTypeEnum {

    /**
     *  to upgraded
     */
    NORMAL_UPGRADE(2),

    /**
     * A consistency upgrade is required.
     */
    CONSISTENT_UPGRADE(3);

    private final int type;

    FirmwareUpgradeTypeEnum(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static FirmwareUpgradeTypeEnum find(int type) {
        return Arrays.stream(values()).filter(typeEnum -> typeEnum.type == type).findAny()
                .orElseThrow(() -> new CloudSDKException(FirmwareUpgradeTypeEnum.class, type));

    }

}
