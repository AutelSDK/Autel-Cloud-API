package com.autel.great.mqtt.model.control;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.control.LensStorageSettingsEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PhotoStorageSetRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    @NotNull
    @Size(min = 1)
    private List<LensStorageSettingsEnum> photoStorageSettings;

    public PhotoStorageSetRequest() {
    }

    @Override
    public String toString() {
        return "PhotoStorageSetRequest{" +
                "payloadIndex=" + payloadIndex +
                ", photoStorageSettings=" + photoStorageSettings +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public PhotoStorageSetRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }

    public List<LensStorageSettingsEnum> getPhotoStorageSettings() {
        return photoStorageSettings;
    }

    public PhotoStorageSetRequest setPhotoStorageSettings(List<LensStorageSettingsEnum> photoStorageSettings) {
        this.photoStorageSettings = photoStorageSettings;
        return this;
    }
}
