package com.autel.great.mqtt.model.device;

public class IrMeteringPoint {

    private Float x;

    private Float y;

    private Float temperature;

    public IrMeteringPoint() {
    }

    @Override
    public String toString() {
        return "IrMeteringPoint{" +
                "x=" + x +
                ", y=" + y +
                ", temperature=" + temperature +
                '}';
    }

    public Float getX() {
        return x;
    }

    public IrMeteringPoint setX(Float x) {
        this.x = x;
        return this;
    }

    public Float getY() {
        return y;
    }

    public IrMeteringPoint setY(Float y) {
        this.y = y;
        return this;
    }

    public Float getTemperature() {
        return temperature;
    }

    public IrMeteringPoint setTemperature(Float temperature) {
        this.temperature = temperature;
        return this;
    }
}
