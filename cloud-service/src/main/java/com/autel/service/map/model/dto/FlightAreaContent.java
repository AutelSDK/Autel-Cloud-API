package com.autel.service.map.model.dto;

import com.autel.great.mqtt.model.map.ElementGeometryType;
import com.autel.great.mqtt.model.map.ElementProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightAreaContent {

    @NotNull
    @Valid
    private ElementProperty properties;

    @NotNull
    @Valid
    private ElementGeometryType geometry;

}
