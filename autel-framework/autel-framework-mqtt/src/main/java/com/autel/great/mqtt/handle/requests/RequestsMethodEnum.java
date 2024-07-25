package com.autel.great.mqtt.handle.requests;


import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.model.config.RequestsConfigRequest;
import com.autel.great.mqtt.model.flightarea.FlightAreasGetRequest;
import com.autel.great.mqtt.model.map.OfflineMapGetRequest;
import com.autel.great.mqtt.model.media.StorageConfigGet;
import com.autel.great.mqtt.model.organization.AirportBindStatusRequest;
import com.autel.great.mqtt.model.organization.AirportOrganizationBindRequest;
import com.autel.great.mqtt.model.organization.AirportOrganizationGetRequest;
import com.autel.great.mqtt.model.wayline.FlighttaskResourceGetRequest;

import java.util.Arrays;

public enum RequestsMethodEnum {

    STORAGE_CONFIG_GET("storage_config_get", ChannelName.INBOUND_REQUESTS_STORAGE_CONFIG_GET, StorageConfigGet.class),

    AIRPORT_BIND_STATUS("airport_bind_status", ChannelName.INBOUND_REQUESTS_AIRPORT_BIND_STATUS, AirportBindStatusRequest.class),

    AIRPORT_ORGANIZATION_BIND("airport_organization_bind", ChannelName.INBOUND_REQUESTS_AIRPORT_ORGANIZATION_BIND, AirportOrganizationBindRequest.class),

    AIRPORT_ORGANIZATION_GET("airport_organization_get", ChannelName.INBOUND_REQUESTS_AIRPORT_ORGANIZATION_GET, AirportOrganizationGetRequest.class),

    FLIGHT_TASK_RESOURCE_GET("flighttask_resource_get", ChannelName.INBOUND_REQUESTS_FLIGHTTASK_RESOURCE_GET, FlighttaskResourceGetRequest.class),

    CONFIG("config", ChannelName.INBOUND_REQUESTS_CONFIG, RequestsConfigRequest.class),

    FLIGHT_AREAS_GET("flight_areas_get", ChannelName.INBOUND_REQUESTS_FLIGHT_AREAS_GET, FlightAreasGetRequest.class),

    OFFLINE_MAP_GET("offline_map_get", ChannelName.INBOUND_REQUESTS_OFFLINE_MAP_GET, OfflineMapGetRequest.class),

    UNKNOWN("", ChannelName.DEFAULT, Object.class);

    private final String method;

    private final String channelName;

    private final Class classType;

    RequestsMethodEnum(String method, String channelName, Class classType) {
        this.method = method;
        this.channelName = channelName;
        this.classType = classType;
    }

    public String getMethod() {
        return method;
    }

    public String getChannelName() {
        return channelName;
    }

    public Class getClassType() {
        return classType;
    }

    public static RequestsMethodEnum find(String method) {
        return Arrays.stream(RequestsMethodEnum.values())
                .filter(methodEnum -> methodEnum.method.equals(method))
                .findAny().orElse(UNKNOWN);
    }
}
