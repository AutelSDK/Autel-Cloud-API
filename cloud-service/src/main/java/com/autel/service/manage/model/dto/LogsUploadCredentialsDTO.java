package com.autel.service.manage.model.dto;

import com.autel.great.context.enums.oss.OssTypeEnum;
import com.autel.great.context.model.CredentialsToken;
import com.autel.great.mqtt.model.log.FileUploadStartParam;
import com.autel.great.mqtt.model.storage.StsCredentialsResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogsUploadCredentialsDTO {

    private String bucket;

    private CredentialsToken credentials;

    private String endpoint;

    @JsonProperty("file_store_dir")
    private String objectKeyPrefix;

    private OssTypeEnum provider;

    @Builder.Default
    private String fileType = "text_log";

    private FileUploadStartParam params;

    private String region;

    public LogsUploadCredentialsDTO(StsCredentialsResponse sts) {
        this.bucket = sts.getBucket();
        long expire = sts.getCredentials().getExpire();
        sts.getCredentials().setExpire(System.currentTimeMillis() + (expire - 60) * 1000);
        this.credentials = sts.getCredentials();
        this.endpoint = sts.getEndpoint();
        this.objectKeyPrefix = sts.getObjectKeyPrefix();
        this.provider = sts.getProvider();
        this.region = sts.getRegion();
    }
}
