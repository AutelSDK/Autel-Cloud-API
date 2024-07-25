package com.autel.great.context.enums.version;


public class GatewayThingVersion {

    private IThingVersion thingVersion;

    public GatewayThingVersion(IThingVersion thingVersion) {
        this.thingVersion = thingVersion;
    }

    public GatewayThingVersion(GatewayTypeEnum type, String thingVersion) {
        switch (type) {
            case DOCK:
                this.thingVersion = DockThingVersionEnum.find(thingVersion);
                return;
            case DOCK2:
                this.thingVersion = Dock2ThingVersionEnum.find(thingVersion);
                return;
            case RC:
                this.thingVersion = RcThingVersionEnum.find(thingVersion);
                return;
            case EVO_DOCK:
                this.thingVersion = RcThingVersionEnum.find(thingVersion);
                return;
            case EVO_AV_DOCK:
                this.thingVersion = DockThingVersionEnum.find(thingVersion);
                return;
            case EVO_AD_DOCK:
                this.thingVersion = DockThingVersionEnum.find(thingVersion);
        }
    }

    public String getThingVersion() {
        return thingVersion.getThingVersion();
    }

    public CloudSDKVersionEnum getCloudSDKVersion() {
        return thingVersion.getCloudSDKVersion();
    }
}
