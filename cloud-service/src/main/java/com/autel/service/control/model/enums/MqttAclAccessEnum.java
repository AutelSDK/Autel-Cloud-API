package com.autel.service.control.model.enums;

import lombok.Getter;


@Getter
public enum MqttAclAccessEnum {

    SUB(1),

    PUB(2),

    ALL(3);

    int value;

    MqttAclAccessEnum(int value) {
        this.value = value;
    }
}
