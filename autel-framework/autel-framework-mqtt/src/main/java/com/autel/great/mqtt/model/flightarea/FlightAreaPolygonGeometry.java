package com.autel.great.mqtt.model.flightarea;

import com.autel.great.mqtt.enums.flightarea.GeometryTypeEnum;

import java.util.Arrays;

public class FlightAreaPolygonGeometry extends FlightAreaGeometry {

    private final GeometryTypeEnum type = GeometryTypeEnum.POLYGON;

    private Double[][][] coordinates;

    public FlightAreaPolygonGeometry() {
    }

    @Override
    public String toString() {
        return "FlightAreaPointGeometry{" +
                "type=" + type +
                ", coordinates=" + Arrays.toString(coordinates) +
                '}';
    }

    public GeometryTypeEnum getType() {
        return type;
    }

    public Double[][][] getCoordinates() {
        return coordinates;
    }

    public FlightAreaPolygonGeometry setCoordinates(Double[][][] coordinates) {
        this.coordinates = coordinates;
        return this;
    }
}
