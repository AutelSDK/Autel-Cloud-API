package com.autel.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.autel.service.*.dao")
@SpringBootApplication
@EnableScheduling
@ComponentScan("com.autel")
public class ServiceCloudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCloudApiApplication.class, args);
    }

}
