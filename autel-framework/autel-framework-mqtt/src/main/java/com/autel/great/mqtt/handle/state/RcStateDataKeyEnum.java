package com.autel.great.mqtt.handle.state;

import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.model.device.*;
import com.autel.great.mqtt.model.livestream.RcLivestreamAbilityUpdate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public enum RcStateDataKeyEnum {

    FIRMWARE_VERSION(Set.of("firmware_version"), FirmwareVersion.class),

    LIVE_CAPACITY(Set.of("live_capacity"), RcLivestreamAbilityUpdate.class),

    CONTROL_SOURCE(Set.of("control_source"), RcDroneControlSource.class),

    LIVE_STATUS(Set.of("live_status"), RcLiveStatus.class),

    PAYLOAD_FIRMWARE(PayloadModelConst.getAllModelWithPosition(), PayloadFirmwareVersion.class),
    ;

    private final Set<String> keys;

    private final Class classType;


    RcStateDataKeyEnum(Set<String> keys, Class classType) {
        this.keys = keys;
        this.classType = classType;
    }

    public Class getClassType() {
        return classType;
    }

    public Set<String> getKeys() {
        return keys;
    }

    public static RcStateDataKeyEnum find(Set<String> keys) {
        return Arrays.stream(values()).filter(keyEnum -> !Collections.disjoint(keys, keyEnum.keys)).findAny()
                .orElseThrow(() -> new CloudSDKException(RcStateDataKeyEnum.class, keys));
    }

}
