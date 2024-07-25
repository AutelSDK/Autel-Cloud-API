package com.autel.great.mqtt.model.media;

public class HighestPriorityUploadFlightTaskMedia {

    private String flightId;

    public HighestPriorityUploadFlightTaskMedia() {
    }

    @Override
    public String toString() {
        return "HighestPriorityUploadFlightTaskMedia{" +
                "flightId='" + flightId + '\'' +
                '}';
    }

    public String getFlightId() {
        return flightId;
    }

    public HighestPriorityUploadFlightTaskMedia setFlightId(String flightId) {
        this.flightId = flightId;
        return this;
    }
}
