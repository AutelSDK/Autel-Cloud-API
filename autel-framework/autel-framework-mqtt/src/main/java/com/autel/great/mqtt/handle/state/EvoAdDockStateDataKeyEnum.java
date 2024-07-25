package com.autel.great.mqtt.handle.state;


import com.autel.great.mqtt.model.device.EvoDockTargetDetectResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public enum EvoAdDockStateDataKeyEnum {

    FIRMWARE_VERSION(Set.of("firmware_version"), EvoDockTargetDetectResult.class),
    ;

    private final Set<String> keys;

    private final Class classType;


    EvoAdDockStateDataKeyEnum(Set<String> keys, Class classType) {
        this.keys = keys;
        this.classType = classType;
    }

    public Class getClassType() {
        return classType;
    }

    public Set<String> getKeys() {
        return keys;
    }

    public static EvoAdDockStateDataKeyEnum find(Set<String> keys) {
        return Arrays.stream(values()).filter(keyEnum -> !Collections.disjoint(keys, keyEnum.keys)).findAny().orElse(EvoAdDockStateDataKeyEnum.FIRMWARE_VERSION);
    }

}
