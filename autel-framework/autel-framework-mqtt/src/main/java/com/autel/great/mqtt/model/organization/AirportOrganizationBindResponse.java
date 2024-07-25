package com.autel.great.mqtt.model.organization;


import com.autel.great.context.base.BaseModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class AirportOrganizationBindResponse extends BaseModel {

    @NotNull
    @Size(min = 1, max = 2)
    private List<@Valid OrganizationBindInfo> errInfos;

    public AirportOrganizationBindResponse() {
    }

    @Override
    public String toString() {
        return "AirportOrganizationBindResponse{" +
                "errInfos=" + errInfos +
                '}';
    }

    public List<OrganizationBindInfo> getErrInfos() {
        return errInfos;
    }

    public AirportOrganizationBindResponse setErrInfos(List<OrganizationBindInfo> errInfos) {
        this.errInfos = errInfos;
        return this;
    }
}
