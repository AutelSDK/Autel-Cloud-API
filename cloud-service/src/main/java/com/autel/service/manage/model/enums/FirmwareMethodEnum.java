package com.autel.service.manage.model.enums;

import lombok.Getter;

@Getter
public enum FirmwareMethodEnum {

    OTA_CREATE("ota_create");

    private String method;

    FirmwareMethodEnum(String method) {
        this.method = method;
    }

}
