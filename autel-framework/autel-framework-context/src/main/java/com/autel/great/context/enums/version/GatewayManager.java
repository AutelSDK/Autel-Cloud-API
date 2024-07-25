package com.autel.great.context.enums.version;

import com.autel.great.context.annotations.CloudSDKVersion;

import java.util.Arrays;
import java.util.Objects;


public class GatewayManager {

    private String gatewaySn;
    private GatewayThingVersion gatewayThingVersion;
    private DroneThingVersionEnum droneThingVersion;
    private GatewayTypeEnum type;
    private CloudSDKVersionEnum sdkVersion;
    private String droneSn;

    private GatewayManager(String gatewaySn, String droneSn, GatewayTypeEnum gatewayType) {
        this.gatewaySn = gatewaySn;
        this.type = gatewayType;
        this.droneSn = droneSn;
    }

    public GatewayManager(String gatewaySn, String droneSn, GatewayTypeEnum gatewayType, String gatewayThingVersion, String droneThingVersion) {
        this(gatewaySn, droneSn, gatewayType);
        this.gatewayThingVersion = new GatewayThingVersion(gatewayType, gatewayThingVersion);
        if (GatewayTypeEnum.RC == gatewayType) {
            this.sdkVersion = CloudSDKVersionEnum.V0_0_1;
            return;
        }
        if (Objects.isNull(droneThingVersion)) {
            this.sdkVersion = this.gatewayThingVersion.getCloudSDKVersion();
            return;
        }
        this.droneThingVersion = DroneThingVersionEnum.find(droneThingVersion);
        this.sdkVersion = this.gatewayThingVersion.getCloudSDKVersion().isSupported(this.droneThingVersion.getCloudSDKVersion()) ?
                this.droneThingVersion.getCloudSDKVersion() : this.gatewayThingVersion.getCloudSDKVersion();
    }

    public String getGatewaySn() {
        return gatewaySn;
    }

    public GatewayThingVersion getGatewayThingVersion() {
        return gatewayThingVersion;
    }

    public DroneThingVersionEnum getDroneThingVersion() {
        return droneThingVersion;
    }

    public GatewayTypeEnum getType() {
        return type;
    }

    public CloudSDKVersionEnum getSdkVersion() {
        return sdkVersion;
    }

    public String getDroneSn() {
        return droneSn;
    }

    public boolean isTypeSupport(CloudSDKVersion version) {
        return null != version && Arrays.stream(version.exclude()).noneMatch(typeEnum -> typeEnum == this.getType())
                && (version.include().length == 0
                    || Arrays.stream(version.include()).anyMatch(typeEnum -> typeEnum == this.getType()));
    }

    public boolean isVersionSupport(CloudSDKVersion version) {
        return null != version && this.getSdkVersion().isSupported(version.since()) && !isDeprecated(version);
    }

    public boolean isDeprecated(CloudSDKVersion version) {
        return null != version && this.getSdkVersion().isDeprecated(version.deprecated());
    }

    public boolean isPropertyValid(CloudSDKVersion version) {
        return null == version ||
                (!this.getSdkVersion().isDeprecated(version.since())
                        && this.getSdkVersion().isSupported(version.since()));
    }
}
