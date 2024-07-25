package com.autel.service.manage.controller;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.web.core.AuthInterceptor;
import com.autel.service.manage.model.dto.WorkspaceDTO;
import com.autel.service.manage.service.IWorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("${url.manage.prefix}${url.manage.version}/workspaces")
public class WorkspaceController {

    @Autowired
    private IWorkspaceService workspaceService;
    @GetMapping("/current")
    public HttpResultResponse getCurrentWorkspace(HttpServletRequest request) {
        CustomClaim customClaim = (CustomClaim)request.getAttribute(AuthInterceptor.TOKEN_CLAIM);
        Optional<WorkspaceDTO> workspaceOpt = workspaceService.getWorkspaceByWorkspaceId(customClaim.getWorkspaceId());

        return workspaceOpt.isEmpty() ? HttpResultResponse.error() : HttpResultResponse.success(workspaceOpt.get());
    }
}