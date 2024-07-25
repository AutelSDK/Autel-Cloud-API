package com.autel.service.map.model.param;

import com.autel.great.mqtt.enums.flightarea.GeofenceTypeEnum;
import com.autel.service.map.model.dto.FlightAreaContent;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class PostFlightAreaParam {

    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private GeofenceTypeEnum type;

    @NotNull
    @Valid
    private FlightAreaContent content;
}
