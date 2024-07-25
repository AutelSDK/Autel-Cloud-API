package com.autel.great.mqtt.enums.hms;

public enum HmsMessageLanguageEnum {

    EN("en"),

    ZH("zh");

    private final String language;

    HmsMessageLanguageEnum(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}