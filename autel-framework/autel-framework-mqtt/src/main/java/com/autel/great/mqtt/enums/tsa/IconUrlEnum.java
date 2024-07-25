package com.autel.great.mqtt.enums.tsa;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum IconUrlEnum {

    SELECT_CAR("resource://pilot/drawable/tsa_car_select"),

    NORMAL_CAR("resource://pilot/drawable/tsa_car_normal"),

    SELECT_PERSON("resource://pilot/drawable/tsa_person_select"),

    NORMAL_PERSON("resource://pilot/drawable/tsa_person_normal"),

    SELECT_EQUIPMENT("resource://pilot/drawable/tsa_equipment_select"),

    NORMAL_EQUIPMENT("resource://pilot/drawable/tsa_equipment_normal");

    private final String url;

    IconUrlEnum(String url) {
        this.url = url;
    }

    @JsonValue
    public String getUrl() {
        return url;
    }
}
