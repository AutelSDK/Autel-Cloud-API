package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class IrMeteringPointSetRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    @Min(0)
    @Max(1)
    private Float x;

    @NotNull
    @Min(0)
    @Max(1)
    private Float y;

    public IrMeteringPointSetRequest() {
    }

    @Override
    public String toString() {
        return "IrMeteringPointSetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public IrMeteringPointSetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public Float getX() {
        return x;
    }

    public IrMeteringPointSetRequest setX(Float x) {
        this.x = x;
        return this;
    }

    public Float getY() {
        return y;
    }

    public IrMeteringPointSetRequest setY(Float y) {
        this.y = y;
        return this;
    }
}
