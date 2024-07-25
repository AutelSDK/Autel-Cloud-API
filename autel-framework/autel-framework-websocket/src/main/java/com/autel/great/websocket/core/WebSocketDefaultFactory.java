package com.autel.great.websocket.core;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;


@Component
public class WebSocketDefaultFactory implements WebSocketHandlerDecoratorFactory {

    @Override
    public WebSocketHandler decorate(WebSocketHandler handler) {
        return new WebSocketDefaultHandler(handler);
    }
}