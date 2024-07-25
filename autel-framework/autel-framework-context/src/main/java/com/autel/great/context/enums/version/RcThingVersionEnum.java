package com.autel.great.context.enums.version;

import com.fasterxml.jackson.annotation.JsonValue;


public enum RcThingVersionEnum implements IThingVersion {

    V1_0_0("1.0.0", CloudSDKVersionEnum.V0_0_1);

    private final String thingVersion;

    private final CloudSDKVersionEnum cloudSDKVersion;

    RcThingVersionEnum(String thingVersion, CloudSDKVersionEnum cloudSDKVersion) {
        this.thingVersion = thingVersion;
        this.cloudSDKVersion = cloudSDKVersion;
    }

    @JsonValue
    public String getThingVersion() {
        return thingVersion;
    }

    public CloudSDKVersionEnum getCloudSDKVersion() {
        return cloudSDKVersion;
    }

    public static RcThingVersionEnum find(String thingVersion) {
        return V1_0_0;
    }
}
