package com.autel.service.storage.controller;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.model.storage.StsCredentialsResponse;
import com.autel.service.storage.service.IStorageService;
import com.autel.api.storage.IHttpStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class StorageController implements IHttpStorageService {

    @Autowired
    private IStorageService storageService;

    @Override
    public HttpResultResponse<StsCredentialsResponse> getTemporaryCredential(String workspaceId, HttpServletRequest req, HttpServletResponse rsp) {
        StsCredentialsResponse stsCredentials = storageService.getSTSCredentials();
        return HttpResultResponse.success(stsCredentials);
    }
}
