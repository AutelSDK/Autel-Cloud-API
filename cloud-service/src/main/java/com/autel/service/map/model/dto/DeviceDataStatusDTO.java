package com.autel.service.map.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDataStatusDTO {

    private String deviceSn;

    private String nickname;

    private String deviceName;

    private Boolean online;

    private DeviceFlightAreaDTO flightAreaStatus;
}
