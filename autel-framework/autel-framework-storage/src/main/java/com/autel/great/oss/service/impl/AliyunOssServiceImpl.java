package com.autel.great.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.autel.great.context.enums.oss.OssTypeEnum;
import com.autel.great.context.model.CredentialsToken;
import com.autel.great.oss.model.OssConfiguration;
import com.autel.great.oss.service.IOssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Objects;

@Service
@Slf4j
public class AliyunOssServiceImpl implements IOssService {

    private OSS ossClient;
    
    @Override
    public OssTypeEnum getOssType() {
        return OssTypeEnum.ALIYUN;
    }

    @Override
    public CredentialsToken getCredentials() {

        try {
            DefaultProfile profile = DefaultProfile.getProfile(
                    OssConfiguration.region, OssConfiguration.accessKey, OssConfiguration.secretKey);
            IAcsClient client = new DefaultAcsClient(profile);

            AssumeRoleRequest request = new AssumeRoleRequest();
            request.setDurationSeconds(OssConfiguration.expire);
            request.setRoleArn(OssConfiguration.roleArn);
            request.setRoleSessionName(OssConfiguration.roleSessionName);

            AssumeRoleResponse.Credentials response = client.getAcsResponse(request).getCredentials();
            return new CredentialsToken(response.getAccessKeyId(), response.getAccessKeySecret(), response.getSecurityToken(), OssConfiguration.expire);

        } catch (ClientException e) {
            log.debug("Failed to obtain sts.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public URL getObjectUrl(String bucket, String objectKey) {
        boolean isExist = ossClient.doesObjectExist(bucket, objectKey);
        if (!isExist) {
            throw new OSSException("The object does not exist.");
        }

        return ossClient.generatePresignedUrl(bucket, objectKey,
                new Date(System.currentTimeMillis() + OssConfiguration.expire * 1000));
    }

    @Override
    public Boolean deleteObject(String bucket, String objectKey) {
        if (!ossClient.doesObjectExist(bucket, objectKey)) {
            return true;
        }
        ossClient.deleteObject(bucket, objectKey);
        return true;
    }

    @Override
    public InputStream getObject(String bucket, String objectKey) {
        return ossClient.getObject(bucket, objectKey).getObjectContent();
    }

    @Override
    public void putObject(String bucket, String objectKey, InputStream input) {
        if (ossClient.doesObjectExist(bucket, objectKey)) {
            throw new RuntimeException("The filename already exists.");
        }
        PutObjectResult objectResult = ossClient.putObject(new PutObjectRequest(bucket, objectKey, input, new ObjectMetadata()));
        log.info("Upload FlighttaskCreateFile: {}", objectResult.getETag());
    }

    public void createClient() {
        if (Objects.nonNull(this.ossClient)) {
            return;
        }
        this.ossClient = new OSSClientBuilder()
                .build(OssConfiguration.endpoint, OssConfiguration.accessKey, OssConfiguration.secretKey);
    }
}
