package com.autel.great.mqtt.model.livestream;

import com.autel.great.mqtt.enums.livestream.VideoTypeEnum;

public class RcLiveCapacityVideo {

    private String videoIndex;

    private VideoTypeEnum videoType;

    public RcLiveCapacityVideo() {
    }

    @Override
    public String toString() {
        return "RcLiveCapacityVideo{" +
                "videoIndex='" + videoIndex + '\'' +
                ", videoType=" + videoType +
                '}';
    }

    public String getVideoIndex() {
        return videoIndex;
    }

    public RcLiveCapacityVideo setVideoIndex(String videoIndex) {
        this.videoIndex = videoIndex;
        return this;
    }

    public VideoTypeEnum getVideoType() {
        return videoType;
    }

    public RcLiveCapacityVideo setVideoType(VideoTypeEnum videoType) {
        this.videoType = videoType;
        return this;
    }
}