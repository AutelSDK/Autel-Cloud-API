package com.autel.great.mqtt.model.control;

import com.autel.great.mqtt.enums.wayline.WaylineErrorCodeEnum;
import com.autel.great.mqtt.enums.control.FlyToStatusEnum;

public class FlyToPointProgress {

    private WaylineErrorCodeEnum result;

    private FlyToStatusEnum status;

    private String flyToId;

    private Integer wayPointIndex;

    public FlyToPointProgress() {
    }

    @Override
    public String toString() {
        return "FlyToPointProgress{" +
                "result=" + result +
                ", status=" + status +
                ", flyToId='" + flyToId + '\'' +
                ", wayPointIndex=" + wayPointIndex +
                '}';
    }

    public WaylineErrorCodeEnum getResult() {
        return result;
    }

    public FlyToPointProgress setResult(WaylineErrorCodeEnum result) {
        this.result = result;
        return this;
    }

    public FlyToStatusEnum getStatus() {
        return status;
    }

    public FlyToPointProgress setStatus(FlyToStatusEnum status) {
        this.status = status;
        return this;
    }

    public String getFlyToId() {
        return flyToId;
    }

    public FlyToPointProgress setFlyToId(String flyToId) {
        this.flyToId = flyToId;
        return this;
    }

    public Integer getWayPointIndex() {
        return wayPointIndex;
    }

    public FlyToPointProgress setWayPointIndex(Integer wayPointIndex) {
        this.wayPointIndex = wayPointIndex;
        return this;
    }
}
