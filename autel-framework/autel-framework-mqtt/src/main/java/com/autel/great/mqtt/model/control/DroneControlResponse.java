package com.autel.great.mqtt.model.control;

public class DroneControlResponse {

    private Long seq;

    public DroneControlResponse() {
    }

    @Override
    public String toString() {
        return "DroneControlResponse{" +
                "seq=" + seq +
                '}';
    }

    public Long getSeq() {
        return seq;
    }

    public DroneControlResponse setSeq(Long seq) {
        this.seq = seq;
        return this;
    }

}
