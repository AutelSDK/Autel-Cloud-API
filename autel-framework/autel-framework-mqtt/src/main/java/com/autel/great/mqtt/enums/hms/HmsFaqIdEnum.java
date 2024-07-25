package com.autel.great.mqtt.enums.hms;

import com.autel.great.context.enums.device.DeviceDomainEnum;
import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum HmsFaqIdEnum {

    DOCK_TIP("dock_tip_", DeviceDomainEnum.DOCK),

    FPV_TIP("fpv_tip_", DeviceDomainEnum.DRONE);

    private final String text;

    private final DeviceDomainEnum domain;

    @JsonValue
    public String getText() {
        return text;
    }

    public DeviceDomainEnum getDomain() {
        return domain;
    }

    HmsFaqIdEnum(String text, DeviceDomainEnum domain) {
        this.text = text;
        this.domain = domain;
    }

    public static HmsFaqIdEnum find(DeviceDomainEnum domain) {
        return Arrays.stream(values()).filter(faqIdEnum -> faqIdEnum.domain == domain).findAny()
                .orElseThrow(() -> new CloudSDKException(HmsFaqIdEnum.class, domain));
    }
}

