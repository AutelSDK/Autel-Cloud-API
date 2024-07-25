package com.autel.service.map.service;



import com.autel.great.mqtt.model.map.GetMapElementsResponse;

import java.util.List;
import java.util.Optional;

public interface IGroupService {

    List<GetMapElementsResponse> getAllGroupsByWorkspaceId(String workspaceId, String groupId, Boolean isDistributed);

    Optional<GetMapElementsResponse> getCustomGroupByWorkspaceId(String workspaceId);
}
