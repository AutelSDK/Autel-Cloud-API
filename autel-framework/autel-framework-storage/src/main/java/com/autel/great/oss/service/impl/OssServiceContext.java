package com.autel.great.oss.service.impl;

import com.autel.great.context.enums.oss.OssTypeEnum;
import com.autel.great.context.model.CredentialsToken;
import com.autel.great.oss.model.OssConfiguration;
import com.autel.great.oss.service.IOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class OssServiceContext {

    private IOssService ossService;

    @Autowired
    public OssServiceContext(List<IOssService> ossServices, OssConfiguration configuration) {
        if (!OssConfiguration.enable) {
            return;
        }
        this.ossService = ossServices.stream()
                .filter(ossService -> ossService.getOssType() == OssConfiguration.provider)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Oss provider is illegal. Optional: " +
                        Arrays.toString(Arrays.stream(OssTypeEnum.values()).map(OssTypeEnum::getType).toArray())));
    }

    IOssService getOssService() {
        return this.ossService;
    }

    public CredentialsToken getCredentials() {
        return this.ossService.getCredentials();
    }

    public URL getObjectUrl(String bucket, String objectKey) {
        if (!StringUtils.hasText(bucket) || !StringUtils.hasText(objectKey)) {
            throw new IllegalArgumentException();
        }
        return this.ossService.getObjectUrl(bucket, objectKey);
    }

    public Boolean deleteObject(String bucket, String objectKey) {
        return this.ossService.deleteObject(bucket, objectKey);
    }

    public InputStream getObject(String bucket, String objectKey) {
        return this.ossService.getObject(bucket, objectKey);
    }

    public void putObject(String bucket, String objectKey, InputStream stream) {
        this.ossService.putObject(bucket, objectKey, stream);
    }

    void createClient() {
        this.ossService.createClient();
    }
}
