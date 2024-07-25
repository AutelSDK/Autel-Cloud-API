package com.autel.service.manage.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum StateSwitchEnum {

    DISABLE, ENABLE;

    public static Optional<StateSwitchEnum> find(int value) {
        return Arrays.stream(StateSwitchEnum.values()).filter(state -> state.ordinal() == value).findAny();
    }
}
