package com.autel.great.context.exception;


import com.autel.great.context.enums.version.CloudSDKVersionEnum;

public class CloudSDKVersionException extends CloudSDKException {

    public CloudSDKVersionException(String thingVersion) {
        super(String.format("The current CloudSDK version(%s) does not support this thing version(%s), " +
                "please replace the corresponding CloudSDK version.)", CloudSDKVersionEnum.DEFAULT.getVersion(), thingVersion));
    }

}
