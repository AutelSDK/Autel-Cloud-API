package com.autel.great.websocket.service;


import com.autel.great.websocket.dto.MyConcurrentWebSocketSession;

import java.util.Collection;

public interface IWebSocketManageService {

    void put(String key, MyConcurrentWebSocketSession val);

    void remove(String key, String sessionId);

    Collection<MyConcurrentWebSocketSession> getValueWithWorkspace(String workspaceId);

    Collection<MyConcurrentWebSocketSession> getValueWithWorkspaceAndUserType(String workspaceId, Integer userType);

    Long getConnectedCount();
}
