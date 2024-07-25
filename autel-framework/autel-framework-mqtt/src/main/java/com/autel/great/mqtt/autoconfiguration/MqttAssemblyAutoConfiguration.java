package com.autel.great.mqtt.autoconfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.IntegrationComponentScan;

import javax.annotation.PostConstruct;

@Slf4j
@ComponentScan("com.autel.great.mqtt")
@IntegrationComponentScan(basePackages = {"com.autel.great.mqtt"})
public class MqttAssemblyAutoConfiguration {
    @PostConstruct
    public void init() {
        log.info("【mqtt】 assembly load");
    }

}
