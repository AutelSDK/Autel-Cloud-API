package com.autel.great.mqtt.enums.flightarea;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FlightAreaMethodEnum {

    FLIGHT_AREAS_UPDATE("flight_areas_update"),

    FLIGHT_AREAS_DELETE("flight_areas_delete"),
    ;

    private final String method;

    FlightAreaMethodEnum(String method) {
        this.method = method;
    }

    @JsonValue
    public String getMethod() {
        return method;
    }
}
