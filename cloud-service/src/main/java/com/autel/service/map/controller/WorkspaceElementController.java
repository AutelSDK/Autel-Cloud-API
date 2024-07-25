package com.autel.service.map.controller;

import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.web.core.AuthInterceptor;
import com.autel.great.mqtt.model.map.CreateMapElementRequest;
import com.autel.great.mqtt.model.map.CreateMapElementResponse;
import com.autel.great.mqtt.model.map.GetMapElementsResponse;
import com.autel.great.mqtt.model.map.UpdateMapElementRequest;
import com.autel.great.websocket.service.IWebSocketMessageService;
import com.autel.api.map.IHttpMapService;
import com.autel.service.map.service.IWorkspaceElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
public class WorkspaceElementController implements IHttpMapService {

    @Autowired
    private IWorkspaceElementService elementService;

    @Autowired
    private IWebSocketMessageService sendMessageService;

    @DeleteMapping("${url.map.prefix}${url.map.version}/workspaces/{workspace_id}/element-groups/{group_id}/elements")
    public HttpResultResponse deleteAllElementByGroupId(@PathVariable(name = "workspace_id") String workspaceId,
                                                        @PathVariable(name = "group_id") String groupId) {

        return elementService.deleteAllElementByGroupId(workspaceId, groupId);
    }

    @Override
    public HttpResultResponse<List<GetMapElementsResponse>> getMapElements(String workspaceId, String groupId, Boolean isDistributed, HttpServletRequest req, HttpServletResponse rsp) {
        List<GetMapElementsResponse> groupsList = elementService.getAllGroupsByWorkspaceId(workspaceId, groupId, isDistributed);
        return HttpResultResponse.<List<GetMapElementsResponse>>success(groupsList);
    }

    @Override
    public HttpResultResponse<CreateMapElementResponse> createMapElement(String workspaceId, String groupId,
                                                                         @Valid CreateMapElementRequest elementCreate, HttpServletRequest req, HttpServletResponse rsp) {
        CustomClaim claims = (CustomClaim) req.getAttribute(AuthInterceptor.TOKEN_CLAIM);
        elementCreate.getResource().setUsername(claims.getUsername());

        HttpResultResponse response = elementService.saveElement(workspaceId, groupId, elementCreate, true);
        if (response.getCode() != HttpResultResponse.CODE_SUCCESS) {
            return response;
        }

        return HttpResultResponse.success(new CreateMapElementResponse().setId(elementCreate.getId()));
    }

    @Override
    public HttpResultResponse updateMapElement(String workspaceId, String elementId, @Valid UpdateMapElementRequest elementUpdate, HttpServletRequest req, HttpServletResponse rsp) {
        CustomClaim claims = (CustomClaim) req.getAttribute(AuthInterceptor.TOKEN_CLAIM);

        HttpResultResponse response = elementService.updateElement(workspaceId, elementId, elementUpdate, claims.getUsername(), true);
        if (response.getCode() != HttpResultResponse.CODE_SUCCESS) {
            return response;
        }

        return response;
    }

    @Override
    public HttpResultResponse deleteMapElement(String workspaceId, String elementId, HttpServletRequest req, HttpServletResponse rsp) {

        return elementService.deleteElement(workspaceId, elementId, true);
    }
}