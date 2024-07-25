package com.autel.great.mqtt.enums.map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MapMethodEnum {

    OFFLINE_MAP_UPDATE("offline_map_update"),

    ;

    private final String method;

    MapMethodEnum(String method) {
        this.method = method;
    }

    @JsonValue
    public String getMethod() {
        return method;
    }
}
