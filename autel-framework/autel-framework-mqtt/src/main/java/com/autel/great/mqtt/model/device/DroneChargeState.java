package com.autel.great.mqtt.model.device;

public class DroneChargeState {

    private Boolean state;

    private Integer capacityPercent;

    public DroneChargeState() {
    }

    @Override
    public String toString() {
        return "DroneChargeState{" +
                "state=" + state +
                ", capacityPercent=" + capacityPercent +
                '}';
    }

    public Boolean getState() {
        return state;
    }

    public DroneChargeState setState(Boolean state) {
        this.state = state;
        return this;
    }

    public Integer getCapacityPercent() {
        return capacityPercent;
    }

    public DroneChargeState setCapacityPercent(Integer capacityPercent) {
        this.capacityPercent = capacityPercent;
        return this;
    }
}
