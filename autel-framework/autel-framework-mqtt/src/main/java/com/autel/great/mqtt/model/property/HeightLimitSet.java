package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class HeightLimitSet extends BaseModel {

    @NotNull
    @Max(1500)
    @Min(20)
    @JsonProperty("height_limit")
    private Integer heightLimit;

    public HeightLimitSet() {
    }

    @Override
    public String toString() {
        return "HeightLimitSet{" +
                "heightLimit=" + heightLimit +
                '}';
    }

    public Integer getHeightLimit() {
        return heightLimit;
    }

    public HeightLimitSet setHeightLimit(Integer heightLimit) {
        this.heightLimit = heightLimit;
        return this;
    }
}
