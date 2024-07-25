package com.autel.great.mqtt.model.device;


import com.autel.great.mqtt.enums.livestream.VideoQualityEnum;

public class RcLiveStatusData {

    private Boolean status;

    private VideoId videoId;

    private VideoQualityEnum videoQuality;

    public RcLiveStatusData() {
    }

    @Override
    public String toString() {
        return "RcLiveStatusData{" +
                "status=" + status +
                ", videoId=" + videoId +
                ", videoQuality=" + videoQuality +
                '}';
    }

    public Boolean getStatus() {
        return status;
    }

    public RcLiveStatusData setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public VideoId getVideoId() {
        return videoId;
    }

    public RcLiveStatusData setVideoId(VideoId videoId) {
        this.videoId = videoId;
        return this;
    }

    public VideoQualityEnum getVideoQuality() {
        return videoQuality;
    }

    public RcLiveStatusData setVideoQuality(VideoQualityEnum videoQuality) {
        this.videoQuality = videoQuality;
        return this;
    }
}