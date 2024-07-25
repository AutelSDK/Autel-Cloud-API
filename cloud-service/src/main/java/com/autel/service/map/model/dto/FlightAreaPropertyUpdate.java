package com.autel.service.map.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightAreaPropertyUpdate {

    private String elementId;

    private Boolean status;

    private Float radius;

}
