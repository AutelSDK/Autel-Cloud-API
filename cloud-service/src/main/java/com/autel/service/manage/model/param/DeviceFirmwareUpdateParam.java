package com.autel.service.manage.model.param;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class DeviceFirmwareUpdateParam {

    @NotNull
    private Boolean status;
}
