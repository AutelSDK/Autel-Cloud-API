package com.autel.great.mqtt.model.wayline;

public class FlighttaskResourceGetRequest {

    private String flightId;

    public FlighttaskResourceGetRequest() {
    }

    @Override
    public String toString() {
        return "FlighttaskResourceGetRequest{" +
                "flightId='" + flightId + '\'' +
                '}';
    }

    public String getFlightId() {
        return flightId;
    }

    public FlighttaskResourceGetRequest setFlightId(String flightId) {
        this.flightId = flightId;
        return this;
    }
}
