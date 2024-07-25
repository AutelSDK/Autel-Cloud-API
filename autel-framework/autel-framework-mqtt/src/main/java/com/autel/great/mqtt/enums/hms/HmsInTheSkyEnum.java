package com.autel.great.mqtt.enums.hms;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HmsInTheSkyEnum {

    IN_THE_SKY("_in_the_sky");

    private final String text;

    HmsInTheSkyEnum(String text) {
        this.text = text;
    }

    @JsonValue
    public String getText() {
        return text;
    }
}