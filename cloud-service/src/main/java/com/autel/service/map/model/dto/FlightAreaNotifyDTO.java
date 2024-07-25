package com.autel.service.map.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightAreaNotifyDTO {

    private String sn;

    private Integer result;

    private String status;

    private String message;
}
