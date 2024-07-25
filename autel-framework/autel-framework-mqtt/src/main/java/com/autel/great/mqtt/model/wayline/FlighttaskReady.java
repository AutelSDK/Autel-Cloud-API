package com.autel.great.mqtt.model.wayline;

import java.util.List;

public class FlighttaskReady {

    /**
     * The task ID set that currently satisfies the task readiness conditions
     */
    private List<String> flightIds;

    public FlighttaskReady() {
    }

    @Override
    public String toString() {
        return "FlighttaskReady{" +
                "flightIds=" + flightIds +
                '}';
    }

    public List<String> getFlightIds() {
        return flightIds;
    }

    public FlighttaskReady setFlightIds(List<String> flightIds) {
        this.flightIds = flightIds;
        return this;
    }
}
