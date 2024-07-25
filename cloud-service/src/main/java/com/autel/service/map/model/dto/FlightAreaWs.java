package com.autel.service.map.model.dto;

import com.autel.great.mqtt.enums.flightarea.GeofenceTypeEnum;
import com.autel.service.map.model.enums.FlightAreaOpertaionEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FlightAreaWs {

    private FlightAreaOpertaionEnum operation;

    private String areaId;

    private String name;

    private GeofenceTypeEnum type;

    private FlightAreaContent content;

    private Boolean status;

    private String username;

    private Long createTime;

    private Long updateTime;

}
