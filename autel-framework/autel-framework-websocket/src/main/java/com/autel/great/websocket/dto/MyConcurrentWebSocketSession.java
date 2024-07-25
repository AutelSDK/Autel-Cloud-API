package com.autel.great.websocket.dto;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.ConcurrentWebSocketSessionDecorator;

public class MyConcurrentWebSocketSession extends ConcurrentWebSocketSessionDecorator {

    private static final int SEND_BUFFER_SIZE_LIMIT = 1024 * 1024;

    private static final int SEND_TIME_LIMIT = 1000;

    private MyConcurrentWebSocketSession(WebSocketSession delegate, int sendTimeLimit, int bufferSizeLimit) {
        super(delegate, sendTimeLimit, bufferSizeLimit);
    }

    public MyConcurrentWebSocketSession(WebSocketSession delegate) {
        this(delegate, SEND_TIME_LIMIT, SEND_BUFFER_SIZE_LIMIT);
    }

}