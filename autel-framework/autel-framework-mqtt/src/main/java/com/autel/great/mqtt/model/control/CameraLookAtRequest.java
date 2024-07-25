package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CameraLookAtRequest extends BaseModel {

    /**
     * Camera enumeration.
     * It is unofficial device_mode_key.
     * The format is *{type-subtype-gimbalindex}*.
     * Please read [Product Supported](https://developer.dji.com/doc/cloud-api-tutorial/en/overview/product-support.html)
     */
    @NotNull
    private PayloadIndex payloadIndex;

    /**
     * Whether the relative location of drone head and gimbal is locked
     */
    @NotNull
    private Boolean locked;

    /**
     * The latitude of target point is angular values.
     * Negative values for south latitude and positive values for north latitude.
     * It is accurate to six decimal places.
     */
    @Min(-90)
    @Max(90)
    @NotNull
    private Float latitude;

    /**
     * The latitude of target point is angular values.
     * Negative values for west longitude and positive values for east longitude.
     * It is accurate to six decimal places.
     */
    @NotNull
    @Min(-180)
    @Max(180)
    private Float longitude;

    /**
     * Ellipsoid height
     */
    @NotNull
    @Min(2)
    @Max(10000)
    private Float height;

    public CameraLookAtRequest() {
    }

    @Override
    public String toString() {
        return "CameraLookAtRequest{" +
                "payloadIndex=" + payloadIndex +
                ", locked=" + locked +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", height=" + height +
                '}';
    }

    public CameraLookAtRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public CameraLookAtRequest setLocked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    public CameraLookAtRequest setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public CameraLookAtRequest setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public CameraLookAtRequest setHeight(Float height) {
        this.height = height;
        return this;
    }
}
