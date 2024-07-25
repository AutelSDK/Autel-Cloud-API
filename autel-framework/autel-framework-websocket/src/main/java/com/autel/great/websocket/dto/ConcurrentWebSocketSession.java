package com.autel.great.websocket.dto;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.ConcurrentWebSocketSessionDecorator;


public class ConcurrentWebSocketSession extends ConcurrentWebSocketSessionDecorator {

    private static final int SEND_BUFFER_SIZE_LIMIT = 1024 * 1024;

    private static final int SEND_TIME_LIMIT = 1000;

    private ConcurrentWebSocketSession(WebSocketSession delegate, int sendTimeLimit, int bufferSizeLimit) {
        super(delegate, sendTimeLimit, bufferSizeLimit);
    }

    ConcurrentWebSocketSession(WebSocketSession delegate) {
        this(delegate, SEND_TIME_LIMIT, SEND_BUFFER_SIZE_LIMIT);
    }

}