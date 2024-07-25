package com.autel.service.manage.model.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ntp.server")
public class NtpServerProperties {

    public static String host;

    public void setHost(String host) {
        NtpServerProperties.host = host;
    }
}
