package com.autel.great.mqtt.model.control;


import com.autel.great.context.base.BaseModel;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class FlyToPointUpdateRequest extends BaseModel {

    @Min(1)
    @Max(15)
    @NotNull
    private Integer maxSpeed;

    /**
     * The M30 series only support one point.
     */
    @Size(min = 1, max = 1)
    @NotNull
    private List<@Valid Point> points;

    public FlyToPointUpdateRequest() {
    }

    @Override
    public String toString() {
        return "FlyToPointUpdateRequest{" +
                "maxSpeed=" + maxSpeed +
                ", points=" + points +
                '}';
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public FlyToPointUpdateRequest setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public List<Point> getPoints() {
        return points;
    }

    public FlyToPointUpdateRequest setPoints(List<Point> points) {
        this.points = points;
        return this;
    }
}
