package com.autel.great.context.enums.device;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Arrays;

@Schema(description = "device domain", enumAsRef = true)
public enum DeviceDomainEnum {
    /**
     * 飞机类
     */
    DRONE(0),
    /**
     * 负载类
     */
    PAYLOAD(1),
    /**
     * 遥控器类
     */
    REMOTER_CONTROL(2),
    /**
     * 机场类
     */
    DOCK(3),

    ;

    private final int domain;

    DeviceDomainEnum(int domain) {
        this.domain = domain;
    }

    @JsonCreator
    public static DeviceDomainEnum find(int domain) {
        return Arrays.stream(values()).filter(domainEnum -> domainEnum.domain == domain).findAny()
                .orElseThrow(() -> new CloudSDKException(DeviceDomainEnum.class, domain));
    }

    @JsonValue
    public int getDomain() {
        return domain;
    }
}
