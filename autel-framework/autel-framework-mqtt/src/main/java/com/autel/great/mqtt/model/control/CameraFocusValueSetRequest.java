package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.control.ExposureCameraTypeEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;

public class CameraFocusValueSetRequest extends BaseModel {

    /**
     * Camera enumeration.
     * It is unofficial device_mode_key.
     * The format is *{type-subtype-gimbalindex}*.
     * Please read [Product Supported](https://developer.dji.com/doc/cloud-api-tutorial/en/overview/product-support.html)
     */
    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    private ExposureCameraTypeEnum cameraType;

    @NotNull
    private Integer focusValue;

    public CameraFocusValueSetRequest() {
    }

    @Override
    public String toString() {
        return "CameraFocusValueSetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", cameraType=" + cameraType +
                ", focusValue=" + focusValue +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraFocusValueSetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public ExposureCameraTypeEnum getCameraType() {
        return cameraType;
    }

    public CameraFocusValueSetRequest setCameraType(ExposureCameraTypeEnum cameraType) {
        this.cameraType = cameraType;
        return this;
    }

    public Integer getFocusValue() {
        return focusValue;
    }

    public CameraFocusValueSetRequest setFocusValue(Integer focusValue) {
        this.focusValue = focusValue;
        return this;
    }
}
