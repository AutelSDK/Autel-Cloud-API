package com.autel.great.mqtt.core;


import com.autel.great.context.enums.device.DeviceDomainEnum;
import com.autel.great.context.enums.device.DeviceEnum;
import com.autel.great.context.enums.device.DeviceSubTypeEnum;
import com.autel.great.context.enums.device.DeviceTypeEnum;
import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.context.enums.version.GatewayTypeEnum;
import com.autel.great.context.exception.CloudSDKErrorEnum;
import com.autel.great.context.exception.CloudSDKException;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class SDKManager {

    private SDKManager() {
    }

    private static final ConcurrentHashMap<String, GatewayManager> SDK_MAP = new ConcurrentHashMap<>(16);

    public static GatewayManager getDeviceSDK(String gatewaySn) {
        if (SDK_MAP.containsKey(gatewaySn)) {
            return SDK_MAP.get(gatewaySn);
        }
        throw new CloudSDKException(CloudSDKErrorEnum.NOT_REGISTERED,
                "The device has not been registered, please call the 'SDKManager.registerDevice()' method to register the device first.");
    }

    public static GatewayManager registerDevice(String gatewaySn, String droneSn,
                                                DeviceDomainEnum domain, DeviceTypeEnum type, DeviceSubTypeEnum subType, String gatewayThingVersion, String droneThingVersion) {
        return registerDevice(gatewaySn, droneSn, GatewayTypeEnum.find(DeviceEnum.find(domain, type, subType)), gatewayThingVersion, droneThingVersion);
    }

    public static GatewayManager registerDevice(String gatewaySn, String droneSn, GatewayTypeEnum type, String gatewayThingVersion, String droneThingVersion) {
        return registerDevice(new GatewayManager(Objects.requireNonNull(gatewaySn), droneSn, type, gatewayThingVersion, droneThingVersion));
    }

    public static GatewayManager registerDevice(GatewayManager gateway) {
        SDK_MAP.put(gateway.getGatewaySn(), gateway);
        return gateway;
    }

    public static void logoutDevice(String gatewaySn) {
        SDK_MAP.remove(gatewaySn);
    }
}
