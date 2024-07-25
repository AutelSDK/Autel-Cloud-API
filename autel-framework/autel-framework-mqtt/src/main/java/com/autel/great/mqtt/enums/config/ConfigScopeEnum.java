package com.autel.great.mqtt.enums.config;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum ConfigScopeEnum {

    PRODUCT("product");

    private final String scope;

    ConfigScopeEnum(String scope) {
        this.scope = scope;
    }

    @JsonValue
    public String getScope() {
        return scope;
    }

    @JsonCreator
    public static ConfigScopeEnum find(String scope) {
        return Arrays.stream(values()).filter(scopeEnum -> scopeEnum.scope.equals(scope)).findAny()
                .orElseThrow(() -> new CloudSDKException(ConfigScopeEnum.class, scope));
    }
}
