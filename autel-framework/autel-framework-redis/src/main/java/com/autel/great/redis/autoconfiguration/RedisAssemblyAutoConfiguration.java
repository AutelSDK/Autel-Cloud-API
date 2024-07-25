package com.autel.great.redis.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@Slf4j
@ComponentScan("com.autel.great.redis")
public class RedisAssemblyAutoConfiguration {
    @PostConstruct
    public void init() {
        log.info("【redis】 assembly load");
    }
}
