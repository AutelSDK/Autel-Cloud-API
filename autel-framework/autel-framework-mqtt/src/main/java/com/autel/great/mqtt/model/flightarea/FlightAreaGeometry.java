package com.autel.great.mqtt.model.flightarea;

import com.autel.great.mqtt.enums.flightarea.GeometryTypeEnum;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type",
        include = JsonTypeInfo.As.EXISTING_PROPERTY, defaultImpl = FlightAreaGeometry.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FlightAreaPointGeometry.class, name = "Point"),
        @JsonSubTypes.Type(value = FlightAreaPolygonGeometry.class, name = "Polygon")
})
public abstract class FlightAreaGeometry {

    private GeometryTypeEnum type;

}
