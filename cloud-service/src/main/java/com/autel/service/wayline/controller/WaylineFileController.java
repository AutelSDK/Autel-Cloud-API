package com.autel.service.wayline.controller;

import com.autel.api.wayline.IHttpWaylineService;
import com.autel.great.context.enums.device.DeviceEnum;
import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.page.PaginationData;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.web.core.AuthInterceptor;
import com.autel.great.mqtt.enums.wayline.WaylineTypeEnum;
import com.autel.great.mqtt.model.wayline.GetWaylineListRequest;
import com.autel.great.mqtt.model.wayline.GetWaylineListResponse;
import com.autel.great.mqtt.model.wayline.WaylineUploadCallbackMetadata;
import com.autel.great.mqtt.model.wayline.WaylineUploadCallbackRequest;
import com.autel.service.wayline.model.dto.WaylineFileDTO;
import com.autel.service.wayline.service.IWaylineFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class WaylineFileController implements IHttpWaylineService {

    @Autowired
    private IWaylineFileService waylineFileService;

    @DeleteMapping("${url.wayline.prefix}${url.wayline.version}/workspaces/{workspace_id}/waylines/{wayline_id}")
    public HttpResultResponse deleteWayline(@PathVariable(name = "workspace_id") String workspaceId,
                                            @PathVariable(name = "wayline_id") String waylineId) {
        boolean isDel = waylineFileService.deleteByWaylineId(workspaceId, waylineId);
        return isDel ? HttpResultResponse.success() : HttpResultResponse.error("Failed to delete wayline.");
    }

    @PostMapping("${url.wayline.prefix}${url.wayline.version}/workspaces/{workspace_id}/waylines/file/upload")
    public HttpResultResponse importKmzFile(HttpServletRequest request, MultipartFile file) {
        if (Objects.isNull(file)) {
            return HttpResultResponse.error("No file received.");
        }
        CustomClaim customClaim = (CustomClaim) request.getAttribute(AuthInterceptor.TOKEN_CLAIM);
        String workspaceId = customClaim.getWorkspaceId();
        String creator = customClaim.getUsername();
        waylineFileService.importKmzFile(file, workspaceId, creator);
        return HttpResultResponse.success();
    }

    @Override
    public HttpResultResponse<PaginationData<GetWaylineListResponse>> getWaylineList(@Valid GetWaylineListRequest request, String workspaceId, HttpServletRequest req, HttpServletResponse rsp) {
        PaginationData<GetWaylineListResponse> data = waylineFileService.getWaylinesByParam(workspaceId, request);
        return HttpResultResponse.success(data);
    }

    @Override
    public void getWaylineFileDownloadAddress(String workspaceId, String waylineId, HttpServletRequest req, HttpServletResponse rsp) {
        try {
            URL url = waylineFileService.getObjectUrl(workspaceId, waylineId);
            rsp.sendRedirect(url.toString());

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HttpResultResponse<List<String>> getDuplicatedWaylineName(String workspaceId, @NotNull @Size(min = 1) List<String> names, HttpServletRequest req, HttpServletResponse rsp) {
        List<String> existNamesList = waylineFileService.getDuplicateNames(workspaceId, names);

        return HttpResultResponse.success(existNamesList);
    }

    @Override
    public HttpResultResponse fileUploadResultReport(String workspaceId, @Valid WaylineUploadCallbackRequest request, HttpServletRequest req, HttpServletResponse rsp) {
        CustomClaim customClaim = (CustomClaim) req.getAttribute(AuthInterceptor.TOKEN_CLAIM);

        WaylineUploadCallbackMetadata metadata = request.getMetadata();

        WaylineFileDTO file = WaylineFileDTO.builder()
                .username(customClaim.getUsername())
                .objectKey(request.getObjectKey())
                .name(request.getName())
                .templateTypes(metadata.getTemplateTypes().stream().map(WaylineTypeEnum::getValue).collect(Collectors.toList()))
                .payloadModelKeys(metadata.getPayloadModelKeys().stream().map(DeviceEnum::getDevice).collect(Collectors.toList()))
                .droneModelKey(metadata.getDroneModelKey().getDevice())
                .build();

        int id = waylineFileService.saveWaylineFile(workspaceId, file);

        return id <= 0 ? HttpResultResponse.error() : HttpResultResponse.success();
    }

    @Override
    public HttpResultResponse batchFavoritesWayline(String workspaceId, @NotNull @Size(min = 1) List<String> ids, HttpServletRequest req, HttpServletResponse rsp) {
        boolean isMark = waylineFileService.markFavorite(workspaceId, ids, true);

        return isMark ? HttpResultResponse.success() : HttpResultResponse.error();
    }

    @Override
    public HttpResultResponse batchUnfavoritesWayline(String workspaceId, @NotNull @Size(min = 1) List<String> ids, HttpServletRequest req, HttpServletResponse rsp) {
        boolean isMark = waylineFileService.markFavorite(workspaceId, ids, false);

        return isMark ? HttpResultResponse.success() : HttpResultResponse.error();
    }
}
