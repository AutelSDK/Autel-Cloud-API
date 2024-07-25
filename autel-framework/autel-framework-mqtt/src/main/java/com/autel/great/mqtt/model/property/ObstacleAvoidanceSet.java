package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.model.device.ObstacleAvoidance;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ObstacleAvoidanceSet extends BaseModel {

    @Valid
    @NotNull
    private ObstacleAvoidance obstacleAvoidance;

    public ObstacleAvoidanceSet() {
    }

    @Override
    public String toString() {
        return "ObstacleAvoidanceSet{" +
                "obstacleAvoidance=" + obstacleAvoidance +
                '}';
    }

    public ObstacleAvoidance getObstacleAvoidance() {
        return obstacleAvoidance;
    }

    public ObstacleAvoidanceSet setObstacleAvoidance(ObstacleAvoidance obstacleAvoidance) {
        this.obstacleAvoidance = obstacleAvoidance;
        return this;
    }
}
