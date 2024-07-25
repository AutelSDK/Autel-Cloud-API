package com.autel.great.mqtt.model.organization;


import com.autel.great.context.base.BaseModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class AirportBindStatusResponse extends BaseModel {

    @NotNull
    @Size(min = 1, max = 2)
    private List<@Valid BindStatusRequestDevice> bindStatus;

    public AirportBindStatusResponse() {
    }

    @Override
    public String toString() {
        return "AirportBindStatusResponse{" +
                "bindStatus=" + bindStatus +
                '}';
    }

    public List<BindStatusRequestDevice> getBindStatus() {
        return bindStatus;
    }

    public AirportBindStatusResponse setBindStatus(List<BindStatusRequestDevice> bindStatus) {
        this.bindStatus = bindStatus;
        return this;
    }
}
