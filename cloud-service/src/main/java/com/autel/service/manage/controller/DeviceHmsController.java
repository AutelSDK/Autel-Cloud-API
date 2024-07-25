package com.autel.service.manage.controller;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.page.PaginationData;
import com.autel.service.manage.model.dto.DeviceHmsDTO;
import com.autel.service.manage.model.param.DeviceHmsQueryParam;
import com.autel.service.manage.service.IDeviceHmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@Slf4j
@RequestMapping("${url.manage.prefix}${url.manage.version}/devices")
public class DeviceHmsController {

    @Autowired
    private IDeviceHmsService deviceHmsService;

    @GetMapping("/{workspace_id}/devices/hms")
    public HttpResultResponse<PaginationData<DeviceHmsDTO>> getHmsInformation(DeviceHmsQueryParam param,
                                                                              @PathVariable("workspace_id") String workspaceId) {
        PaginationData<DeviceHmsDTO> devices = deviceHmsService.getDeviceHmsByParam(param);

        return HttpResultResponse.success(devices);
    }

    @PutMapping("/{workspace_id}/devices/hms/{device_sn}")
    public HttpResultResponse updateReadHmsByDeviceSn(@PathVariable("device_sn") String deviceSn) {
        deviceHmsService.updateUnreadHms(deviceSn);
        return HttpResultResponse.success();
    }
    @GetMapping("/{workspace_id}/devices/hms/{device_sn}")
    public HttpResultResponse<List<DeviceHmsDTO>> getUnreadHmsByDeviceSn(@PathVariable("device_sn") String deviceSn) {
        PaginationData<DeviceHmsDTO> paginationData = deviceHmsService.getDeviceHmsByParam(
                DeviceHmsQueryParam.builder()
                        .deviceSn(new HashSet<>(Set.of(deviceSn)))
                        .updateTime(0L)
                        .build());
        return HttpResultResponse.success(paginationData.getList());
    }
}
