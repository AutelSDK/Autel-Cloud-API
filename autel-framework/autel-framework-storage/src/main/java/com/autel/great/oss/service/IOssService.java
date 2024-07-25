package com.autel.great.oss.service;


import com.autel.great.context.enums.oss.OssTypeEnum;
import com.autel.great.context.model.CredentialsToken;

import java.io.InputStream;
import java.net.URL;

public interface IOssService {

    OssTypeEnum getOssType();

    CredentialsToken getCredentials();

    URL getObjectUrl(String bucket, String objectKey);

    Boolean deleteObject(String bucket, String objectKey);

    InputStream getObject(String bucket, String objectKey);

    void putObject(String bucket, String objectKey, InputStream input);

    void createClient();
}
