package com.autel.service.manage.controller;

import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.page.PaginationData;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.web.core.AuthInterceptor;
import com.autel.great.mqtt.model.log.FileUploadUpdateRequest;
import com.autel.service.manage.model.dto.DeviceLogsDTO;
import com.autel.service.manage.model.param.DeviceLogsCreateParam;
import com.autel.service.manage.model.param.DeviceLogsGetParam;
import com.autel.service.manage.model.param.DeviceLogsQueryParam;
import com.autel.service.manage.service.IDeviceLogsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;

@RestController
@Slf4j
@RequestMapping("${url.manage.prefix}${url.manage.version}/workspaces")
public class DeviceLogsController {

    @Autowired
    private IDeviceLogsService deviceLogsService;

    @GetMapping("/{workspace_id}/devices/{device_sn}/logs-uploaded")
    public HttpResultResponse getUploadedLogs(DeviceLogsQueryParam param, @PathVariable("workspace_id") String workspaceId,
                                              @PathVariable("device_sn") String deviceSn) {
        PaginationData<DeviceLogsDTO> data = deviceLogsService.getUploadedLogs(deviceSn, param);
        return HttpResultResponse.success(data);
    }

    @GetMapping("/{workspace_id}/devices/{device_sn}/logs")
    public HttpResultResponse getLogsBySn(@PathVariable("workspace_id") String workspaceId,
                                          @PathVariable("device_sn") String deviceSn,
                                          DeviceLogsGetParam param) {
        return deviceLogsService.getRealTimeLogs(deviceSn, param.getDomainList());
    }

    @PostMapping("/{workspace_id}/devices/{device_sn}/logs")
    public HttpResultResponse uploadLogs(@PathVariable("workspace_id") String workspaceId,
                                         @PathVariable("device_sn") String deviceSn,
                                         HttpServletRequest request, @RequestBody DeviceLogsCreateParam param) {

        CustomClaim customClaim = (CustomClaim) request.getAttribute(AuthInterceptor.TOKEN_CLAIM);

        return deviceLogsService.pushFileUpload(customClaim.getUsername(), deviceSn, param);
    }

    @DeleteMapping("/{workspace_id}/devices/{device_sn}/logs")
    public HttpResultResponse cancelUploadedLogs(@PathVariable("workspace_id") String workspaceId,
                                                 @PathVariable("device_sn") String deviceSn,
                                                 @RequestBody FileUploadUpdateRequest param) {

        return deviceLogsService.pushUpdateFile(deviceSn, param);
    }

    @DeleteMapping("/{workspace_id}/devices/{device_sn}/logs/{logs_id}")
    public HttpResultResponse deleteUploadedLogs(@PathVariable("workspace_id") String workspaceId,
                                                 @PathVariable("device_sn") String deviceSn,
                                                 @PathVariable("logs_id") String logsId) {
        deviceLogsService.deleteLogs(deviceSn, logsId);
        return HttpResultResponse.success();
    }

    @GetMapping("/{workspace_id}/logs/{logs_id}/url/{file_id}")
    public HttpResultResponse getFileUrl(@PathVariable(name = "workspace_id") String workspaceId,
                                         @PathVariable(name = "file_id") String fileId,
                                         @PathVariable(name = "logs_id") String logsId, HttpServletResponse response) {

        try {
            URL url = deviceLogsService.getLogsFileUrl(logsId, fileId);
            return HttpResultResponse.success(url.toString());
        } catch (Exception e) {
            log.error("Failed to get the logs file download address.");
            e.printStackTrace();
        }
        return HttpResultResponse.error("Failed to get the logs file download address.");
    }
}
