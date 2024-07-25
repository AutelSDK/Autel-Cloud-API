package com.autel.great.mqtt.model.flightarea;

public class FlightAreaFile {

    private String name;
    private String checksum;

    public FlightAreaFile() {
    }

    @Override
    public String toString() {
        return "FlightAreaFile{" +
                "name='" + name + '\'' +
                ", checksum='" + checksum + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public FlightAreaFile setName(String name) {
        this.name = name;
        return this;
    }

    public String getChecksum() {
        return checksum;
    }

    public FlightAreaFile setChecksum(String checksum) {
        this.checksum = checksum;
        return this;
    }
}
