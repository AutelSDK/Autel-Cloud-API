package com.autel.great.mqtt.model.device;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvoDockTargetDetectResult {
    /**
     * 时间戳
     */
    @JsonProperty(value = "time")
    private Long time;
    /**
     * 无人机ID
     */
    @JsonProperty(value = "uav_id")
    private String uavId;

    public EvoDockTargetDetectResult() {
    }
}
