package com.autel.great.mqtt.model.config;

import com.autel.great.mqtt.enums.config.ConfigScopeEnum;
import com.autel.great.mqtt.enums.config.ConfigTypeEnum;

public class RequestsConfigRequest {

    private ConfigTypeEnum configType;

    private ConfigScopeEnum configScope;

    public RequestsConfigRequest() {
    }

    @Override
    public String toString() {
        return "RequestsConfigRequest{" +
                "configType=" + configType +
                ", configScope=" + configScope +
                '}';
    }

    public ConfigTypeEnum getConfigType() {
        return configType;
    }

    public RequestsConfigRequest setConfigType(ConfigTypeEnum configType) {
        this.configType = configType;
        return this;
    }

    public ConfigScopeEnum getConfigScope() {
        return configScope;
    }

    public RequestsConfigRequest setConfigScope(ConfigScopeEnum configScope) {
        this.configScope = configScope;
        return this;
    }
}
