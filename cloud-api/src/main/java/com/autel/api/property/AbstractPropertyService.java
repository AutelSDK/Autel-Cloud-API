package com.autel.api.property;

import com.autel.great.context.annotations.CloudSDKVersion;
import com.autel.great.context.base.BaseModel;
import com.autel.great.context.base.Common;
import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.context.enums.version.GatewayTypeEnum;
import com.autel.great.context.exception.CloudSDKErrorEnum;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.enums.property.PropertySetEnum;
import com.autel.great.mqtt.handle.property.PropertySetPublish;
import com.autel.great.mqtt.handle.property.PropertySetReplyResultEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractPropertyService {

    @Resource
    private PropertySetPublish propertySetPublish;

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public PropertySetReplyResultEnum propertySet(GatewayManager gateway, PropertySetEnum propertyEnum, BaseModel request) {
        checkCondition(gateway, propertyEnum, request);

        Common.validateModel(request);
        Field[] fields = request.getClass().getDeclaredFields();
        if (fields.length > 1 || null == fields[0].getDeclaredAnnotation(Valid.class)) {
            return propertySetPublish.publish(gateway.getGatewaySn(), request);
        }

        try {
            Map<String, Object> map = new HashMap<>();
            fields[0].setAccessible(true);
            Object child = fields[0].get(request);
            for (Field field : ((Class) fields[0].getGenericType()).getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(child);
                if (Objects.isNull(value)) {
                    continue;
                }
                map.put(Optional.ofNullable(field.getDeclaredAnnotation(JsonProperty.class))
                        .map(JsonProperty::value).orElse(field.getName()), value);
                field.setAccessible(false);
                PropertySetReplyResultEnum result = propertySetPublish.publish(
                        gateway.getGatewaySn(), Map.of(propertyEnum.getProperty(), map));
                if (PropertySetReplyResultEnum.SUCCESS != result) {
                    return result;
                }
                map.clear();
            }
            fields[0].setAccessible(false);

        } catch (IllegalAccessException e) {
            throw new CloudSDKException(e);
        }
        return PropertySetReplyResultEnum.SUCCESS;
    }

    private void checkCondition(GatewayManager gateway, PropertySetEnum propertyEnum, BaseModel request) {
        if (Objects.isNull(request) || propertyEnum.getClazz() != request.getClass()) {
            throw new CloudSDKException(CloudSDKErrorEnum.INVALID_PARAMETER);
        }
        if (!propertyEnum.getSupportedDevices().contains(gateway.getType())) {
            throw new CloudSDKException(CloudSDKErrorEnum.DEVICE_TYPE_NOT_SUPPORT);
        }
        if (propertyEnum.isDeprecated() || !gateway.getSdkVersion().isSupported(propertyEnum.getSince())) {
            throw new CloudSDKException(CloudSDKErrorEnum.DEVICE_VERSION_NOT_SUPPORT);
        }
    }
}
