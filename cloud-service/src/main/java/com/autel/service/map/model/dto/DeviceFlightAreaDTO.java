package com.autel.service.map.model.dto;

import com.autel.great.mqtt.enums.flightarea.FlightAreaSyncReasonEnum;
import com.autel.great.mqtt.enums.flightarea.FlightAreaSyncStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceFlightAreaDTO {

    private String deviceSn;

    private String workspaceId;

    private String fileId;

    private FlightAreaSyncStatusEnum syncStatus;

    private FlightAreaSyncReasonEnum syncCode;

    private String syncMsg;
}
