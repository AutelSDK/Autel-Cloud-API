package com.autel.service.media.controller;

import com.autel.api.media.IHttpMediaService;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.model.media.*;
import com.autel.service.media.service.IMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class MediaController implements IHttpMediaService {

    @Autowired
    private IMediaService mediaService;

    @Override
    public HttpResultResponse mediaFastUpload(String workspaceId, @Valid MediaFastUploadRequest request, HttpServletRequest req, HttpServletResponse rsp) {
        boolean isExist = mediaService.fastUpload(workspaceId, request.getFingerprint());

        return isExist ? HttpResultResponse.success() : HttpResultResponse.error(request.getFingerprint() + "don't exist.");
    }

    @Override
    public HttpResultResponse<String> mediaUploadCallback(String workspaceId, @Valid MediaUploadCallbackRequest request, HttpServletRequest req, HttpServletResponse rsp) {
        mediaService.saveMediaFile(workspaceId, request);
        return HttpResultResponse.success(request.getObjectKey());
    }

    @Override
    public HttpResultResponse<GetFileFingerprintResponse> getExistFileTinyFingerprint(String workspaceId, @Valid GetFileFingerprintRequest request, HttpServletRequest req, HttpServletResponse rsp) {
        List<String> existingList = mediaService.getExistTinyFingerprints(workspaceId, request.getTinyFingerprints());
        return HttpResultResponse.success(new GetFileFingerprintResponse().setTinyFingerprints(existingList));
    }

    @Override
    public HttpResultResponse folderUploadCallback(String workspaceId, @Valid FolderUploadCallbackRequest request, HttpServletRequest req, HttpServletResponse rsp) {
        return null;
    }
}