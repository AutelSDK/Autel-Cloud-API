package com.autel.great.context.enums.version;

import com.autel.great.context.enums.device.DeviceEnum;
import com.autel.great.context.exception.CloudSDKException;

import java.util.Arrays;


public enum GatewayTypeEnum {

    RC(DeviceEnum.RC, DeviceEnum.RC_PLUS, DeviceEnum.RC_PRO, DeviceEnum.EVO_RC, DeviceEnum.EVO_AGCS_RC),

    DOCK(DeviceEnum.DOCK),

    DOCK2(DeviceEnum.DOCK2),
    EVO_DOCK(DeviceEnum.EVO_DOCK),
    EVO_AV_DOCK(DeviceEnum.EVO_AV_DOCK),
    EVO_AD_DOCK(DeviceEnum.EVO_AD_DOCK),
    ;

    private final DeviceEnum[] gateway;

    GatewayTypeEnum(DeviceEnum... gateway) {
        this.gateway = gateway;
    }

    public DeviceEnum[] getGateway() {
        return gateway;
    }

    public static GatewayTypeEnum find(DeviceEnum device) {
        return Arrays.stream(values()).filter(gateway -> Arrays.stream(gateway.gateway).anyMatch(deviceEnum -> device == deviceEnum))
                .findAny().orElseThrow(() -> new CloudSDKException(GatewayTypeEnum.class, device));
    }
}
