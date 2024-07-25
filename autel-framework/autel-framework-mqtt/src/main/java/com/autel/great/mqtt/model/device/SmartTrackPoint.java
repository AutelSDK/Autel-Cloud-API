package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.TrackTargetModeEnum;

public class SmartTrackPoint {

    private TrackTargetModeEnum trackTargetMode;

    private Float trackLatitude;

    private Float trackLongitude;

    private Float trackAltitude;

    public SmartTrackPoint() {
    }

    @Override
    public String toString() {
        return "SmartTrackPoint{" +
                "trackTargetMode=" + trackTargetMode +
                ", trackLatitude=" + trackLatitude +
                ", trackLongitude=" + trackLongitude +
                ", trackAltitude=" + trackAltitude +
                '}';
    }

    public TrackTargetModeEnum getTrackTargetMode() {
        return trackTargetMode;
    }

    public SmartTrackPoint setTrackTargetMode(TrackTargetModeEnum trackTargetMode) {
        this.trackTargetMode = trackTargetMode;
        return this;
    }

    public Float getTrackLatitude() {
        return trackLatitude;
    }

    public SmartTrackPoint setTrackLatitude(Float trackLatitude) {
        this.trackLatitude = trackLatitude;
        return this;
    }

    public Float getTrackLongitude() {
        return trackLongitude;
    }

    public SmartTrackPoint setTrackLongitude(Float trackLongitude) {
        this.trackLongitude = trackLongitude;
        return this;
    }

    public Float getTrackAltitude() {
        return trackAltitude;
    }

    public SmartTrackPoint setTrackAltitude(Float trackAltitude) {
        this.trackAltitude = trackAltitude;
        return this;
    }
}
