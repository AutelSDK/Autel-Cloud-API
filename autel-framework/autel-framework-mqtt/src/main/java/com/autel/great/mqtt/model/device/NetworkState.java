package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.NetworkStateQualityEnum;
import com.autel.great.mqtt.enums.device.NetworkStateTypeEnum;

public class NetworkState {

    private NetworkStateTypeEnum type;

    private NetworkStateQualityEnum quality;

    private Float rate;

    public NetworkState() {
    }

    @Override
    public String toString() {
        return "NetworkState{" +
                "type=" + type +
                ", quality=" + quality +
                ", rate=" + rate +
                '}';
    }

    public NetworkStateTypeEnum getType() {
        return type;
    }

    public NetworkState setType(NetworkStateTypeEnum type) {
        this.type = type;
        return this;
    }

    public NetworkStateQualityEnum getQuality() {
        return quality;
    }

    public NetworkState setQuality(NetworkStateQualityEnum quality) {
        this.quality = quality;
        return this;
    }

    public Float getRate() {
        return rate;
    }

    public NetworkState setRate(Float rate) {
        this.rate = rate;
        return this;
    }
}
