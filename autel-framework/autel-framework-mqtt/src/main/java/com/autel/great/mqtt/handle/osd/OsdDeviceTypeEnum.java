package com.autel.great.mqtt.handle.osd;

import com.autel.great.context.enums.version.GatewayTypeEnum;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.model.device.OsdDock;
import com.autel.great.mqtt.model.device.OsdDockDrone;
import com.autel.great.mqtt.model.device.OsdRcDrone;
import com.autel.great.mqtt.model.device.OsdRemoteControl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum OsdDeviceTypeEnum {

    RC(true, OsdRemoteControl.class, ChannelName.INBOUND_OSD_RC, GatewayTypeEnum.RC),

    DOCK(true, OsdDock.class, ChannelName.INBOUND_OSD_DOCK, GatewayTypeEnum.DOCK, GatewayTypeEnum.DOCK2, GatewayTypeEnum.EVO_DOCK, GatewayTypeEnum.EVO_AD_DOCK, GatewayTypeEnum.EVO_AV_DOCK),

    RC_DRONE(false, OsdRcDrone.class, ChannelName.INBOUND_OSD_RC_DRONE, GatewayTypeEnum.RC),

    DOCK_DRONE(false, OsdDockDrone.class, ChannelName.INBOUND_OSD_DOCK_DRONE, GatewayTypeEnum.DOCK, GatewayTypeEnum.DOCK2, GatewayTypeEnum.EVO_DOCK, GatewayTypeEnum.EVO_AD_DOCK, GatewayTypeEnum.EVO_AV_DOCK);

    private final boolean gateway;

    private final Set<GatewayTypeEnum> gatewayType = new HashSet<>();

    private final Class classType;

    private final String channelName;

    OsdDeviceTypeEnum(boolean gateway, Class classType, String channelName, GatewayTypeEnum... gatewayType) {
        this.gateway = gateway;
        this.classType = classType;
        this.channelName = channelName;
        Collections.addAll(this.gatewayType, gatewayType);
    }

    public Set<GatewayTypeEnum> getGatewayType() {
        return gatewayType;
    }

    public boolean isGateway() {
        return gateway;
    }

    public Class getClassType() {
        return classType;
    }

    public String getChannelName() {
        return channelName;
    }

    public static OsdDeviceTypeEnum find(GatewayTypeEnum gatewayType, boolean isGateway) {
        return Arrays.stream(values()).filter(osdEnum -> osdEnum.gatewayType.contains(gatewayType) && osdEnum.gateway == isGateway).findAny()
                .orElseThrow(() -> new CloudSDKException(OsdDeviceTypeEnum.class, gatewayType, isGateway));
    }

    public static OsdDeviceTypeEnum find(Class classType) {
        return Arrays.stream(values()).filter(type -> type.classType == classType).findAny()
                .orElseThrow(() -> new CloudSDKException(OsdDeviceTypeEnum.class, classType));
    }
}
