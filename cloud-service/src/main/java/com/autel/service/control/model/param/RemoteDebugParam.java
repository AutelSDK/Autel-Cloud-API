package com.autel.service.control.model.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RemoteDebugParam {

    @NotNull
    private Integer action;

}
