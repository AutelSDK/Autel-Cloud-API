package com.autel.great.mqtt.model.interconnection;

import com.autel.great.context.base.BaseModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CustomDataTransmissionToPsdkRequest extends BaseModel {

    /**
     * Data content
     * length: Less than 256
     */
    @NotNull
    @Length(max = 256)
    private String value;

    public CustomDataTransmissionToPsdkRequest() {
    }

    @Override
    public String toString() {
        return "CustomDataTransmissionToPsdkRequest{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public CustomDataTransmissionToPsdkRequest setValue(String value) {
        this.value = value;
        return this;
    }
}
