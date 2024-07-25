package com.autel.service.manage.model.dto;

import com.autel.great.mqtt.enums.livestream.LensChangeVideoTypeEnum;
import com.autel.great.mqtt.enums.livestream.UrlTypeEnum;
import com.autel.great.mqtt.enums.livestream.VideoQualityEnum;
import com.autel.great.mqtt.model.device.VideoId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LiveTypeDTO {

    @JsonProperty("url_type")
    private UrlTypeEnum urlType;

    @JsonProperty("video_id")
    private VideoId videoId;

    @JsonProperty("video_quality")
    private VideoQualityEnum videoQuality;

    private LensChangeVideoTypeEnum videoType;

}