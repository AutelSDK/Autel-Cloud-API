package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.control.GimbalResetModeEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class GimbalResetRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    private GimbalResetModeEnum resetMode;

    public GimbalResetRequest() {
    }

    @Override
    public String toString() {
        return "GimbalResetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", resetMode=" + resetMode +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public GimbalResetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public GimbalResetModeEnum getResetMode() {
        return resetMode;
    }

    public GimbalResetRequest setResetMode(GimbalResetModeEnum resetMode) {
        this.resetMode = resetMode;
        return this;
    }
}
