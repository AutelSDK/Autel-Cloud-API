package com.autel.great.mqtt.model.airsense;

import com.autel.great.mqtt.enums.airsense.AltitudeTypeEnum;
import com.autel.great.mqtt.enums.airsense.VertTrendEnum;
import com.autel.great.mqtt.enums.airsense.WarningLevelEnum;

public class AirsenseWarning {

    private String icao;

    private WarningLevelEnum warningLevel;

    private Float latitude;

    private Float longitude;

    private Integer altitude;

    private AltitudeTypeEnum altitudeType;

    private Float heading;

    private Integer relativeAltitude;

    private VertTrendEnum vertTrend;

    private Integer distance;

    public AirsenseWarning() {
    }

    @Override
    public String toString() {
        return "AirsenseWarning{" +
                "icao='" + icao + '\'' +
                ", warningLevel=" + warningLevel +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", altitudeType=" + altitudeType +
                ", heading=" + heading +
                ", relativeAltitude=" + relativeAltitude +
                ", vertTrend=" + vertTrend +
                ", distance=" + distance +
                '}';
    }

    public String getIcao() {
        return icao;
    }

    public AirsenseWarning setIcao(String icao) {
        this.icao = icao;
        return this;
    }

    public WarningLevelEnum getWarningLevel() {
        return warningLevel;
    }

    public AirsenseWarning setWarningLevel(WarningLevelEnum warningLevel) {
        this.warningLevel = warningLevel;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public AirsenseWarning setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public AirsenseWarning setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public AirsenseWarning setAltitude(Integer altitude) {
        this.altitude = altitude;
        return this;
    }

    public AltitudeTypeEnum getAltitudeType() {
        return altitudeType;
    }

    public AirsenseWarning setAltitudeType(AltitudeTypeEnum altitudeType) {
        this.altitudeType = altitudeType;
        return this;
    }

    public Float getHeading() {
        return heading;
    }

    public AirsenseWarning setHeading(Float heading) {
        this.heading = heading;
        return this;
    }

    public Integer getRelativeAltitude() {
        return relativeAltitude;
    }

    public AirsenseWarning setRelativeAltitude(Integer relativeAltitude) {
        this.relativeAltitude = relativeAltitude;
        return this;
    }

    public VertTrendEnum getVertTrend() {
        return vertTrend;
    }

    public AirsenseWarning setVertTrend(VertTrendEnum vertTrend) {
        this.vertTrend = vertTrend;
        return this;
    }

    public Integer getDistance() {
        return distance;
    }

    public AirsenseWarning setDistance(Integer distance) {
        this.distance = distance;
        return this;
    }
}
