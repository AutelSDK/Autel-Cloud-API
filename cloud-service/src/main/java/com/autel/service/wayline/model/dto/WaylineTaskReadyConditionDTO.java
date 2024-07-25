package com.autel.service.wayline.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WaylineTaskReadyConditionDTO {

    private Integer batteryCapacity;

    private Long beginTime;

    private Long endTime;
}
