package com.autel.great.mqtt.model.organization;

public class AirportOrganizationGetRequest {

    private String deviceBindingCode;

    private String organizationId;

    public AirportOrganizationGetRequest() {
    }

    @Override
    public String toString() {
        return "AirportOrganizationGetRequest{" +
                "deviceBindingCode='" + deviceBindingCode + '\'' +
                ", organizationId='" + organizationId + '\'' +
                '}';
    }

    public String getDeviceBindingCode() {
        return deviceBindingCode;
    }

    public AirportOrganizationGetRequest setDeviceBindingCode(String deviceBindingCode) {
        this.deviceBindingCode = deviceBindingCode;
        return this;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public AirportOrganizationGetRequest setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        return this;
    }
}
