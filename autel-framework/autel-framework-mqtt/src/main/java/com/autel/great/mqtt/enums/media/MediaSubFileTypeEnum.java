package com.autel.great.mqtt.enums.media;

import com.autel.great.context.exception.CloudSDKException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Arrays;

@Schema(description = "The type of image file. <br /><p>0: normal picture; <p/><p>1: panorama.</p>")
public enum MediaSubFileTypeEnum {

    NORMAL(0),

    PANORAMA(1);

    private final int type;

    MediaSubFileTypeEnum(int type) {
        this.type = type;
    }

    @JsonValue
    public int getType() {
        return type;
    }

    @JsonCreator
    public static MediaSubFileTypeEnum find(int type) {
        return Arrays.stream(values()).filter(subFile -> subFile.type == type).findAny()
                .orElseThrow(() -> new CloudSDKException(MediaSubFileTypeEnum.class, type));
    }
}
