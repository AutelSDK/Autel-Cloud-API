package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.control.MeteringModeEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class IrMeteringModeSetRequest extends BaseModel {
    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    private MeteringModeEnum mode;

    public IrMeteringModeSetRequest() {
    }

    @Override
    public String toString() {
        return "IrMeteringModeSetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", mode=" + mode +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public IrMeteringModeSetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public MeteringModeEnum getMode() {
        return mode;
    }

    public IrMeteringModeSetRequest setMode(MeteringModeEnum mode) {
        this.mode = mode;
        return this;
    }
}
