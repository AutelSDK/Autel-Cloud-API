package com.autel.service.map.controller;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.service.map.model.dto.DeviceDataStatusDTO;
import com.autel.service.map.service.IDeviceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${url.map.prefix}${url.map.version}/workspaces")
public class DeviceDataController {

    @Autowired
    private IDeviceDataService deviceDataService;

    @GetMapping("/{workspace_id}/device-status")
    public HttpResultResponse<List<DeviceDataStatusDTO>> getDeviceFlightAreaStatus(@PathVariable(name = "workspace_id") String workspaceId) {
        return HttpResultResponse.success(deviceDataService.getDevicesDataStatus(workspaceId));
    }
}
