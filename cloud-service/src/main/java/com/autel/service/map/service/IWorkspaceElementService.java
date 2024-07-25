package com.autel.service.map.service;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.model.map.*;
import com.autel.service.map.model.dto.GroupElementDTO;

import java.util.List;
import java.util.Optional;

public interface IWorkspaceElementService {

    List<GetMapElementsResponse> getAllGroupsByWorkspaceId(String workspaceId, String groupId, Boolean isDistributed);

    HttpResultResponse saveElement(String workspaceId, String groupId, CreateMapElementRequest elementCreate, boolean notify);

    HttpResultResponse updateElement(String workspaceId, String elementId, UpdateMapElementRequest elementUpdate, String username, boolean notify);

    HttpResultResponse deleteElement(String workspaceId, String elementId, boolean notify);

    Optional<GroupElementDTO> getElementByElementId(String elementId);

    HttpResultResponse deleteAllElementByGroupId(String workspaceId, String groupId);

    MapElementCreateWsResponse element2CreateWsElement(GroupElementDTO element);

    MapElementUpdateWsResponse element2UpdateWsElement(GroupElementDTO element);
}