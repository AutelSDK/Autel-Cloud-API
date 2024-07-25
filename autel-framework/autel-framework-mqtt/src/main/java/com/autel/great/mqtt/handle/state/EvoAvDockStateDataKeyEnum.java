package com.autel.great.mqtt.handle.state;


import com.autel.great.mqtt.model.device.EvoDockTargetDetectResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public enum EvoAvDockStateDataKeyEnum {

    FIRMWARE_VERSION(Set.of("firmware_version"), EvoDockTargetDetectResult.class),
    ;

    private final Set<String> keys;

    private final Class classType;


    EvoAvDockStateDataKeyEnum(Set<String> keys, Class classType) {
        this.keys = keys;
        this.classType = classType;
    }

    public Class getClassType() {
        return classType;
    }

    public Set<String> getKeys() {
        return keys;
    }

    public static EvoAvDockStateDataKeyEnum find(Set<String> keys) {
        return Arrays.stream(values()).filter(keyEnum -> !Collections.disjoint(keys, keyEnum.keys)).findAny().orElse(EvoAvDockStateDataKeyEnum.FIRMWARE_VERSION);
    }

}
