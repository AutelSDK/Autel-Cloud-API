package com.autel.service.map.service;

import com.autel.service.map.model.dto.DeviceDataStatusDTO;
import com.autel.service.map.model.dto.DeviceFlightAreaDTO;

import java.util.List;
import java.util.Optional;

public interface IDeviceDataService {

    List<DeviceDataStatusDTO> getDevicesDataStatus(String workspaceId);

    Optional<DeviceFlightAreaDTO> getDeviceStatus(String workspaceId, String deviceSn);
}
