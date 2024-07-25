package com.autel.great.websocket.core;

import com.autel.great.websocket.service.IWebSocketManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;

@Component
@Primary
public class CustomWebSocketFactory extends WebSocketDefaultFactory {

    @Autowired
    private IWebSocketManageService webSocketManageService;

    @Override
    public WebSocketHandler decorate(WebSocketHandler handler) {
        return new CustomWebSocketHandler(handler, webSocketManageService);
    }
}