package com.autel.service.control.model.param;

import com.autel.service.control.model.enums.PayloadCommandsEnum;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class PayloadCommandsParam {

    private String sn;

    @NotNull
    @Valid
    private PayloadCommandsEnum cmd;

    @Valid
    @NotNull
    private DronePayloadParam data;

}
