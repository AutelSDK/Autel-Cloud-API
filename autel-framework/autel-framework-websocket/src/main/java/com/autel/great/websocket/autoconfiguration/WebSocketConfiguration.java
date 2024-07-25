package com.autel.great.websocket.autoconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;
import org.springframework.web.socket.server.HandshakeHandler;


@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Autowired(required = false)
    private HandshakeHandler handshakeHandler;

    @Autowired
    private WebSocketHandlerDecoratorFactory webSocketHandlerDecoratorFactory;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/api/v1/ws").setAllowedOriginPatterns("*")
                .setHandshakeHandler(handshakeHandler);
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.addDecoratorFactory(webSocketHandlerDecoratorFactory);
    }

}