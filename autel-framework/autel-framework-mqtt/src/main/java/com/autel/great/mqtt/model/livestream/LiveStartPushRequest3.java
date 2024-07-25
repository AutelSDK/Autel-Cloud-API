package com.autel.great.mqtt.model.livestream;

import lombok.Data;

@Data
public class LiveStartPushRequest3 {
    private Integer url_type;
    private String url;
    private String video_id;
    private Integer video_quality;
}