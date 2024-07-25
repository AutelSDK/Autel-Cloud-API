package com.autel.service.media.service;

import com.autel.service.media.model.MediaFileCountDTO;

public interface IMediaRedisService {

    void setMediaCount(String gatewaySn, String jobId, MediaFileCountDTO mediaFile);

    MediaFileCountDTO getMediaCount(String gatewaySn, String jobId);

    boolean delMediaCount(String gatewaySn, String jobId);

    boolean detMediaCountByDeviceSn(String gatewaySn);

    void setMediaHighestPriority(String gatewaySn, MediaFileCountDTO mediaFile);

    MediaFileCountDTO getMediaHighestPriority(String gatewaySn);

    boolean delMediaHighestPriority(String gatewaySn);

}
