package com.autel.great.mqtt.model.interconnection;

import com.autel.great.context.base.BaseModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
public class CustomDataTransmissionToEsdkRequest extends BaseModel {

    @NotNull
    @Length(max = 256)
    private String value;

    public CustomDataTransmissionToEsdkRequest() {
    }

    @Override
    public String toString() {
        return "CustomDataTransmissionToEsdkRequest{" +
                "value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public CustomDataTransmissionToEsdkRequest setValue(String value) {
        this.value = value;
        return this;
    }
}
