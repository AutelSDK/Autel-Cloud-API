package com.autel.service.manage.controller;

import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.page.PaginationData;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.web.core.AuthInterceptor;
import com.autel.service.manage.model.dto.DeviceFirmwareDTO;
import com.autel.service.manage.model.dto.DeviceFirmwareNoteDTO;
import com.autel.service.manage.model.dto.FirmwareFileProperties;
import com.autel.service.manage.model.param.DeviceFirmwareQueryParam;
import com.autel.service.manage.model.param.DeviceFirmwareUpdateParam;
import com.autel.service.manage.model.param.DeviceFirmwareUploadParam;
import com.autel.service.manage.service.IDeviceFirmwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${url.manage.prefix}${url.manage.version}/workspaces")
@Validated
public class DeviceFirmwareController {

    @Autowired
    private IDeviceFirmwareService service;

    @GetMapping("/firmware-release-notes/latest")
    public HttpResultResponse<List<DeviceFirmwareNoteDTO>> getLatestFirmwareNote(@RequestParam("device_name") List<String> deviceNames) {

        List<DeviceFirmwareNoteDTO> releaseNotes = deviceNames.stream()
                .map(deviceName -> service.getLatestFirmwareReleaseNote(deviceName))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        return HttpResultResponse.success(releaseNotes);
    }

    @GetMapping("/{workspace_id}/firmwares")
    public HttpResultResponse<PaginationData<DeviceFirmwareDTO>> getAllFirmwarePagination(
            @PathVariable("workspace_id") String workspaceId, @Valid DeviceFirmwareQueryParam param) {

        PaginationData<DeviceFirmwareDTO> data = service.getAllFirmwarePagination(workspaceId, param);
        return HttpResultResponse.success(data);
    }

    @PostMapping("/{workspace_id}/firmwares/file/upload")
    public HttpResultResponse importFirmwareFile(HttpServletRequest request, @PathVariable("workspace_id") String workspaceId,
                                                 @NotNull(message = "No file received.") MultipartFile file,
                                                 @Valid DeviceFirmwareUploadParam param) {

        if (!file.getOriginalFilename().endsWith(FirmwareFileProperties.FIRMWARE_UAV_FILE_SUFFIX)) {
            return HttpResultResponse.error("The file format is incorrect.");
        }

        CustomClaim customClaim = (CustomClaim) request.getAttribute(AuthInterceptor.TOKEN_CLAIM);
        String creator = customClaim.getUsername();

        service.importFirmwareFile(workspaceId, creator, param, file);
        return HttpResultResponse.success();
    }

    @PutMapping("/{workspace_id}/firmwares/{firmware_id}")
    public HttpResultResponse changeFirmwareStatus(@PathVariable("workspace_id") String workspaceId,
                                                   @PathVariable("firmware_id") String firmwareId,
                                                   @Valid @RequestBody DeviceFirmwareUpdateParam param) {

        service.updateFirmwareInfo(DeviceFirmwareDTO.builder()
                .firmwareId(firmwareId).firmwareStatus(param.getStatus()).build());
        return HttpResultResponse.success();
    }


}
