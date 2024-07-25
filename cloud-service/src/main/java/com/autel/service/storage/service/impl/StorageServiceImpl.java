package com.autel.service.storage.service.impl;

import com.autel.api.media.AbstractMediaService;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.model.media.StorageConfigGet;
import com.autel.great.mqtt.model.storage.StsCredentialsResponse;
import com.autel.great.mqtt.handle.requests.TopicRequestsRequest;
import com.autel.great.mqtt.handle.requests.TopicRequestsResponse;
import com.autel.great.oss.model.OssConfiguration;
import com.autel.great.oss.service.impl.OssServiceContext;
import com.autel.service.storage.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;


@Service
public class StorageServiceImpl extends AbstractMediaService implements IStorageService {

    @Autowired
    private OssServiceContext ossService;

    @Override
    public StsCredentialsResponse getSTSCredentials() {
        return new StsCredentialsResponse()
                .setEndpoint(OssConfiguration.endpoint)
                .setBucket(OssConfiguration.bucket)
                .setCredentials(ossService.getCredentials())
                .setProvider(OssConfiguration.provider)
                .setObjectKeyPrefix(OssConfiguration.objectDirPrefix)
                .setRegion(OssConfiguration.region);
    }

    @Override
    public TopicRequestsResponse<MqttReply<StsCredentialsResponse>> storageConfigGet(TopicRequestsRequest<StorageConfigGet> response, MessageHeaders headers) {
        return new TopicRequestsResponse<MqttReply<StsCredentialsResponse>>().setData(MqttReply.success(getSTSCredentials()));
    }
}
