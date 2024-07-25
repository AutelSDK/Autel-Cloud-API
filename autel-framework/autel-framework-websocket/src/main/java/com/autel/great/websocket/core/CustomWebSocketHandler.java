package com.autel.great.websocket.core;

import com.autel.great.websocket.dto.MyConcurrentWebSocketSession;
import com.autel.great.websocket.service.IWebSocketManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.security.Principal;

@Slf4j
public class CustomWebSocketHandler extends WebSocketDefaultHandler {

    private IWebSocketManageService webSocketManageService;

    CustomWebSocketHandler(WebSocketHandler delegate, IWebSocketManageService webSocketManageService) {
        super(delegate);
        this.webSocketManageService = webSocketManageService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Principal principal = session.getPrincipal();
        if (StringUtils.hasText(principal.getName())) {
            webSocketManageService.put(principal.getName(), new MyConcurrentWebSocketSession(session));
            log.debug("{} is connected. ID: {}. WebSocketSession[current count: {}]",
                    principal.getName(), session.getId(), webSocketManageService.getConnectedCount());
            return;
        }
        session.close();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        Principal principal = session.getPrincipal();
        if (StringUtils.hasText(principal.getName())) {
            webSocketManageService.remove(principal.getName(), session.getId());
            log.debug("{} is disconnected. ID: {}. WebSocketSession[current count: {}]",
                    principal.getName(), session.getId(), webSocketManageService.getConnectedCount());
        }

    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info("received message: {}", message.getPayload());
    }

}