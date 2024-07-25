package com.autel.service.manage.model.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("cloud-api.app")
public class AppLicenseProperties {

    public static String id;

    public static String key;

    public static String license;

    public void setId(String id) {
        AppLicenseProperties.id = id;
    }

    public void setKey(String key) {
        AppLicenseProperties.key = key;
    }

    public void setLicense(String license) {
        AppLicenseProperties.license = license;
    }
}
