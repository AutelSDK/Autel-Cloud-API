package com.autel.service.manage.model.enums;

import com.autel.great.mqtt.enums.config.ConfigScopeEnum;
import com.autel.service.manage.service.IRequestsConfigService;
import com.autel.service.manage.service.impl.ConfigProductServiceImpl;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum CustomizeConfigScopeEnum {

    PRODUCT(ConfigScopeEnum.PRODUCT, ConfigProductServiceImpl.class);

    ConfigScopeEnum scope;

    Class<? extends IRequestsConfigService> clazz;

    CustomizeConfigScopeEnum(ConfigScopeEnum scope, Class<? extends IRequestsConfigService> clazz) {
        this.scope = scope;
        this.clazz = clazz;
    }

    public static Optional<CustomizeConfigScopeEnum> find(String scope) {
        return Arrays.stream(CustomizeConfigScopeEnum.values()).filter(scopeEnum -> scopeEnum.scope.getScope().equals(scope)).findAny();
    }
}
