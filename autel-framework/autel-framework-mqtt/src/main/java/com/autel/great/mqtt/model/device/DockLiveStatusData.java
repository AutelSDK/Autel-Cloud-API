package com.autel.great.mqtt.model.device;


import com.autel.great.mqtt.enums.livestream.VideoQualityEnum;
import com.autel.great.mqtt.enums.livestream.VideoTypeEnum;

public class DockLiveStatusData {

    private Boolean status;

    private VideoId videoId;

    private VideoQualityEnum videoQuality;

    private VideoTypeEnum videoType;

    private DockLiveErrorStatus errorStatus;

    public DockLiveStatusData() {
    }

    @Override
    public String toString() {
        return "DockLiveStatusData{" +
                "status=" + status +
                ", videoId=" + videoId +
                ", videoQuality=" + videoQuality +
                ", videoType=" + videoType +
                ", errorStatus=" + errorStatus +
                '}';
    }

    public Boolean getStatus() {
        return status;
    }

    public DockLiveStatusData setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public VideoId getVideoId() {
        return videoId;
    }

    public DockLiveStatusData setVideoId(VideoId videoId) {
        this.videoId = videoId;
        return this;
    }

    public VideoQualityEnum getVideoQuality() {
        return videoQuality;
    }

    public DockLiveStatusData setVideoQuality(VideoQualityEnum videoQuality) {
        this.videoQuality = videoQuality;
        return this;
    }

    public VideoTypeEnum getVideoType() {
        return videoType;
    }

    public DockLiveStatusData setVideoType(VideoTypeEnum videoType) {
        this.videoType = videoType;
        return this;
    }

    public DockLiveErrorStatus getErrorStatus() {
        return errorStatus;
    }

    public DockLiveStatusData setErrorStatus(DockLiveErrorStatus errorStatus) {
        this.errorStatus = errorStatus;
        return this;
    }
}