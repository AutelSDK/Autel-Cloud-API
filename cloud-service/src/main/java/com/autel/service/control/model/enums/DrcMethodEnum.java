package com.autel.service.control.model.enums;

import lombok.Getter;
@Getter
public enum DrcMethodEnum {

    DRC_MODE_ENTER("drc_mode_enter"),

    DRC_MODE_EXIT("drc_mode_exit");

    String method;

    DrcMethodEnum(String method) {
        this.method = method;
    }
}
