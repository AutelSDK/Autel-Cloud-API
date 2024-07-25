package com.autel.service.manage.service;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.model.device.VideoId;
import com.autel.service.manage.model.dto.CapacityDeviceDTO;
import com.autel.service.manage.model.dto.LiveTypeDTO;

import java.util.List;

public interface ILiveStreamService {

    List<CapacityDeviceDTO> getLiveCapacity(String workspaceId);

    HttpResultResponse liveStart(LiveTypeDTO liveParam);

    HttpResultResponse liveStop(VideoId videoId);

    HttpResultResponse liveSetQuality(LiveTypeDTO liveParam);

    HttpResultResponse liveLensChange(LiveTypeDTO liveParam);
}
