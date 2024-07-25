package com.autel.great.mqtt.model.flightarea;

import java.util.List;

public class FlightAreasDroneLocation {
    private List<DroneLocation> droneLocations;

    public FlightAreasDroneLocation() {
    }

    @Override
    public String toString() {
        return "FlightAreasDroneLocation{" +
                "droneLocations=" + droneLocations +
                '}';
    }

    public List<DroneLocation> getDroneLocations() {
        return droneLocations;
    }

    public FlightAreasDroneLocation setDroneLocations(List<DroneLocation> droneLocations) {
        this.droneLocations = droneLocations;
        return this;
    }
}
