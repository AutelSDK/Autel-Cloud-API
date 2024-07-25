package com.autel.service.map.service.impl;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.model.map.*;
import com.autel.great.websocket.enums.BizCodeEnum;
import com.autel.great.websocket.service.IWebSocketMessageService;
import com.autel.service.map.model.dto.GroupElementDTO;
import com.autel.service.map.service.IElementCoordinateService;
import com.autel.service.map.service.IGroupElementService;
import com.autel.service.map.service.IGroupService;
import com.autel.service.map.service.IWorkspaceElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class WorkspaceElementServiceImpl implements IWorkspaceElementService {

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IGroupElementService groupElementService;

    @Autowired
    private IElementCoordinateService elementCoordinateService;

    @Autowired
    private IWebSocketMessageService webSocketMessageService;

    @Override
    public List<GetMapElementsResponse> getAllGroupsByWorkspaceId(String workspaceId, String groupId, Boolean isDistributed) {
        List<GetMapElementsResponse> groupList = groupService.getAllGroupsByWorkspaceId(workspaceId, groupId, isDistributed);
        groupList.forEach(group -> group.setElements(groupElementService.getElementsByGroupId(group.getId())));
        return groupList;
    }

    @Override
    public HttpResultResponse saveElement(String workspaceId, String groupId, CreateMapElementRequest elementCreate, boolean notify) {
        boolean saveElement = groupElementService.saveElement(groupId, elementCreate);
        if (!saveElement) {
            return HttpResultResponse.error("Failed to save the element.");
        }
        if (notify) {
            // Notify all WebSocket connections in this workspace to be updated when an element is created.
            getElementByElementId(elementCreate.getId())
                    .ifPresent(groupElement -> webSocketMessageService.sendBatch(
                            workspaceId, BizCodeEnum.MAP_ELEMENT_CREATE.getCode(),
                            element2CreateWsElement(groupElement)));
        }
        return HttpResultResponse.success();
    }

    @Override
    public HttpResultResponse updateElement(String workspaceId, String elementId, UpdateMapElementRequest elementUpdate, String username, boolean notify) {
        boolean updElement = groupElementService.updateElement(elementId, elementUpdate, username);
        if (!updElement) {
            return HttpResultResponse.error("Failed to update the element.");
        }

        if (notify) {
            // Notify all WebSocket connections in this workspace to update when there is an element update.
            getElementByElementId(elementId)
                    .ifPresent(groupElement -> webSocketMessageService.sendBatch(
                            workspaceId, BizCodeEnum.MAP_ELEMENT_UPDATE.getCode(),
                            element2UpdateWsElement(groupElement)));
        }
        return HttpResultResponse.success();
    }

    @Override
    public HttpResultResponse deleteElement(String workspaceId, String elementId, boolean notify) {
        Optional<GroupElementDTO> elementOpt = getElementByElementId(elementId);
        boolean delElement = groupElementService.deleteElement(elementId);
        if (!delElement) {
            return HttpResultResponse.error("Failed to delete the element.");
        }

        // delete all coordinates according to element id.
        boolean delCoordinate = elementCoordinateService.deleteCoordinateByElementId(elementId);
        if (!delCoordinate) {
            return HttpResultResponse.error("Failed to delete the coordinate.");
        }

        if (notify) {
            // Notify all WebSocket connections in this workspace to update when an element is deleted.
            elementOpt.ifPresent(element ->
                    webSocketMessageService.sendBatch(workspaceId, BizCodeEnum.MAP_ELEMENT_DELETE.getCode(),
                            new MapElementDeleteWsResponse()
                                    .setGroupId(element.getGroupId())
                                    .setId(elementId)));
        }

        return HttpResultResponse.success();
    }

    @Override
    public Optional<GroupElementDTO> getElementByElementId(String elementId) {
        return groupElementService.getElementByElementId(elementId);
    }

    @Override
    public HttpResultResponse deleteAllElementByGroupId(String workspaceId, String groupId) {
        List<MapGroupElement> groupElementList = groupElementService.getElementsByGroupId(groupId);
        for (MapGroupElement groupElement : groupElementList) {
            HttpResultResponse response = this.deleteElement(workspaceId, groupElement.getId(), true);
            if (HttpResultResponse.CODE_SUCCESS != response.getCode()) {
                return response;
            }
        }

        return HttpResultResponse.success();
    }

    public MapElementCreateWsResponse element2CreateWsElement(GroupElementDTO element) {
        if (element == null) {
            return null;
        }
        return new MapElementCreateWsResponse()
                .setId(element.getElementId())
                .setGroupId(element.getGroupId())
                .setName(element.getName())
                .setResource(element.getResource())
                .setUpdateTime(element.getUpdateTime())
                .setCreateTime(element.getCreateTime());
    }

    public MapElementUpdateWsResponse element2UpdateWsElement(GroupElementDTO element) {
        if (element == null) {
            return null;
        }
        return new MapElementUpdateWsResponse()
                .setId(element.getElementId())
                .setGroupId(element.getGroupId())
                .setName(element.getName())
                .setResource(element.getResource())
                .setUpdateTime(element.getUpdateTime())
                .setCreateTime(element.getCreateTime());
    }
}
