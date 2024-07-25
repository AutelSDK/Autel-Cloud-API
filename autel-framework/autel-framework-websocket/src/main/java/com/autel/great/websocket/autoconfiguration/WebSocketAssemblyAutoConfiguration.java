package com.autel.great.websocket.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@Slf4j
@ComponentScan("com.autel.great.websocket")
public class WebSocketAssemblyAutoConfiguration {
    @PostConstruct
    public void init() {
        log.info("【webSocket】 assembly load");
    }

}
