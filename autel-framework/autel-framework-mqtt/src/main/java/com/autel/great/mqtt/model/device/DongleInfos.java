package com.autel.great.mqtt.model.device;

import java.util.List;

public class DongleInfos {

    private List<DongleInfo> dongleInfos;

    public DongleInfos() {
    }

    @Override
    public String toString() {
        return "DongleInfos{" +
                "dongleInfos=" + dongleInfos +
                '}';
    }

    public List<DongleInfo> getDongleInfos() {
        return dongleInfos;
    }

    public DongleInfos setDongleInfos(List<DongleInfo> dongleInfos) {
        this.dongleInfos = dongleInfos;
        return this;
    }
}
