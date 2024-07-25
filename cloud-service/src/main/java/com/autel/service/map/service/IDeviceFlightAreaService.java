package com.autel.service.map.service;

import com.autel.service.map.model.dto.DeviceFlightAreaDTO;

import java.util.Optional;

public interface IDeviceFlightAreaService {

    Optional<DeviceFlightAreaDTO> getDeviceFlightAreaByDevice(String workspaceId, String deviceSn);

    Boolean updateDeviceFile(DeviceFlightAreaDTO deviceFile);

    Boolean updateOrSaveDeviceFile(DeviceFlightAreaDTO deviceFile);
}
