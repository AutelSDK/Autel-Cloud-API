package com.autel.great.context.enums.oss;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "oss type", example = "minio", enumAsRef = true)
public enum OssTypeEnum {

    ALIYUN("ali"),

    AWS("aws"),

    MINIO("minio");

    private String type;

    OssTypeEnum(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
