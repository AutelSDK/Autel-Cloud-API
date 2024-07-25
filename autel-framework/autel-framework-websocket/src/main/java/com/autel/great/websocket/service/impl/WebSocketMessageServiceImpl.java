package com.autel.great.websocket.service.impl;

import com.autel.great.websocket.dto.MyConcurrentWebSocketSession;
import com.autel.great.websocket.dto.WebSocketMessageResponse;
import com.autel.great.websocket.service.IWebSocketManageService;
import com.autel.great.websocket.service.IWebSocketMessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

@Service
@Slf4j
public class WebSocketMessageServiceImpl implements IWebSocketMessageService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private IWebSocketManageService webSocketManageService;

    @Override
    public void sendMessage(MyConcurrentWebSocketSession session, WebSocketMessageResponse message) {
        if (session == null) {
            return;
        }
        try {
            if (!session.isOpen()) {
                session.close();
                log.debug("This session is closed.");
                return;
            }


            session.sendMessage(new TextMessage(mapper.writeValueAsBytes(message)));
        } catch (IOException e) {
            log.info("Failed to publish the message. {}", message.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void sendBatch(Collection<MyConcurrentWebSocketSession> sessions, WebSocketMessageResponse message) {
        if (sessions.isEmpty()) {
            return;
        }

        try {
            TextMessage data = new TextMessage(mapper.writeValueAsBytes(message));
            for (MyConcurrentWebSocketSession session : sessions) {
                if (!session.isOpen()) {
                    session.close();
                    log.debug("This session is closed.");
                    return;
                }
                session.sendMessage(data);
            }
        } catch (IOException e) {
            log.info("Failed to publish the message. {}", message.toString());

            e.printStackTrace();
        }
    }

    @Override
    public void sendBatch(String workspaceId, Integer userType, String bizCode, Object data) {
        if (!StringUtils.hasText(workspaceId)) {
            throw new RuntimeException("Workspace ID does not exist.");
        }
        Collection<MyConcurrentWebSocketSession> sessions = Objects.isNull(userType) ?
                webSocketManageService.getValueWithWorkspace(workspaceId) :
                webSocketManageService.getValueWithWorkspaceAndUserType(workspaceId, userType);

        this.sendBatch(sessions, new WebSocketMessageResponse()
                .setData(Objects.requireNonNullElse(data, ""))
                .setTimestamp(System.currentTimeMillis())
                .setBizCode(bizCode));
    }

    @Override
    public void sendBatch(String workspaceId, String bizCode, Object data) {
        this.sendBatch(workspaceId, null, bizCode, data);
    }
}