package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.control.LensStorageSettingsEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class VideoStorageSetRequest extends BaseModel {

    /**
     * Camera enumeration.
     * It is unofficial device_mode_key.
     * The format is *{type-subtype-gimbalindex}*.
     * Please read [Product Supported](https://developer.dji.com/doc/cloud-api-tutorial/en/overview/product-support.html)
     */
    @NotNull
    private PayloadIndex payloadIndex;

    /**
     * Video storage type. Multi-selection.
     */
    @NotNull
    @Size(min = 1)
    private List<LensStorageSettingsEnum> videoStorageSettings;

    public VideoStorageSetRequest() {
    }

    @Override
    public String toString() {
        return "VideoStorageSetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", videoStorageSettings=" + videoStorageSettings +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public VideoStorageSetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public List<LensStorageSettingsEnum> getVideoStorageSettings() {
        return videoStorageSettings;
    }

    public VideoStorageSetRequest setVideoStorageSettings(List<LensStorageSettingsEnum> videoStorageSettings) {
        this.videoStorageSettings = videoStorageSettings;
        return this;
    }
}
