package com.autel.great.db.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@Slf4j
@ComponentScan("com.autel.great.db")
public class DbAssemblyAutoConfiguration {
    @PostConstruct
    public void init() {
        log.info("【db】 assembly load");
    }
}
