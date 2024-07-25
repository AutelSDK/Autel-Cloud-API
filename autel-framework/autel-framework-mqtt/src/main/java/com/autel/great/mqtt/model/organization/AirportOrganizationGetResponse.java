package com.autel.great.mqtt.model.organization;


import com.autel.great.context.base.BaseModel;

import javax.validation.constraints.NotNull;

public class AirportOrganizationGetResponse extends BaseModel {

    @NotNull
    private String organizationName;

    public AirportOrganizationGetResponse() {
    }

    @Override
    public String toString() {
        return "AirportOrganizationGetResponse{" +
                "organizationName='" + organizationName + '\'' +
                '}';
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public AirportOrganizationGetResponse setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }
}
