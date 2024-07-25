package com.autel.great.mqtt.model.firmware;

import com.autel.great.mqtt.enums.firmware.OtaProgressStatusEnum;

public class OtaCreateResponse {

    /**
     * Mission status
     **/
    private OtaProgressStatusEnum status;

    public OtaCreateResponse() {
    }

    @Override
    public String toString() {
        return "OtaCreateResponse{" +
                "status=" + status +
                '}';
    }

    public OtaProgressStatusEnum getStatus() {
        return status;
    }

    public OtaCreateResponse setStatus(OtaProgressStatusEnum status) {
        this.status = status;
        return this;
    }
}
