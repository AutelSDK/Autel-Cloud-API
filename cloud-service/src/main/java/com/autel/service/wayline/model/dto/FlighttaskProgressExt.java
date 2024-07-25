package com.autel.service.wayline.model.dto;

import lombok.Data;

@Data
public class FlighttaskProgressExt {

    private Integer currentWaypointIndex;

    private Integer mediaCount;

    private String flightId;

    private String trackId;
}
