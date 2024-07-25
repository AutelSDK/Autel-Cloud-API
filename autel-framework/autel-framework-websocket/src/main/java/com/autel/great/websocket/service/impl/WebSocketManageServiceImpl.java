package com.autel.great.websocket.service.impl;

import com.autel.great.redis.RedisConst;
import com.autel.great.redis.RedisOpsUtils;
import com.autel.great.websocket.dto.MyConcurrentWebSocketSession;
import com.autel.great.websocket.enums.UserTypeEnum;
import com.autel.great.websocket.service.IWebSocketManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WebSocketManageServiceImpl implements IWebSocketManageService {

    private static final ConcurrentHashMap<String, MyConcurrentWebSocketSession> SESSIONS = new ConcurrentHashMap<>(16);

    @Override
    public void put(String key, MyConcurrentWebSocketSession val) {
        String[] name = key.split("/");
        if (name.length != 3) {
            log.debug("The key is out of format. [{workspaceId}/{userType}/{userId}]");
            return;
        }
        String sessionId = val.getId();
        String workspaceKey = RedisConst.WEBSOCKET_PREFIX + name[0];
        String userTypeKey = RedisConst.WEBSOCKET_PREFIX + UserTypeEnum.find(Integer.parseInt(name[1])).getDesc();
        RedisOpsUtils.hashSet(workspaceKey, sessionId, name[2]);
        RedisOpsUtils.hashSet(userTypeKey, sessionId, name[2]);
        SESSIONS.put(sessionId, val);
        RedisOpsUtils.expireKey(workspaceKey, RedisConst.WEBSOCKET_ALIVE_SECOND);
        RedisOpsUtils.expireKey(userTypeKey, RedisConst.WEBSOCKET_ALIVE_SECOND);
    }

    @Override
    public void remove(String key, String sessionId) {
        String[] name = key.split("/");
        if (name.length != 3) {
            log.debug("The key is out of format. [{workspaceId}/{userType}/{userId}]");
            return;
        }
        RedisOpsUtils.hashDel(RedisConst.WEBSOCKET_PREFIX + name[0], new String[]{sessionId});
        RedisOpsUtils.hashDel(RedisConst.WEBSOCKET_PREFIX + UserTypeEnum.find(Integer.parseInt(name[1])).getDesc(), new String[]{sessionId});
        SESSIONS.remove(sessionId);
    }

    @Override
    public Collection<MyConcurrentWebSocketSession> getValueWithWorkspace(String workspaceId) {
        if (!StringUtils.hasText(workspaceId)) {
            return Collections.emptySet();
        }
        String key = RedisConst.WEBSOCKET_PREFIX + workspaceId;

        return RedisOpsUtils.hashKeys(key)
                .stream()
                .map(SESSIONS::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<MyConcurrentWebSocketSession> getValueWithWorkspaceAndUserType(String workspaceId, Integer userType) {
        String key = RedisConst.WEBSOCKET_PREFIX + UserTypeEnum.find(userType).getDesc();
        return RedisOpsUtils.hashKeys(key)
                .stream()
                .map(SESSIONS::get)
                .filter(getValueWithWorkspace(workspaceId)::contains)
                .collect(Collectors.toSet());
    }

    @Override
    public Long getConnectedCount() {
        return SESSIONS.mappingCount();
    }
}
