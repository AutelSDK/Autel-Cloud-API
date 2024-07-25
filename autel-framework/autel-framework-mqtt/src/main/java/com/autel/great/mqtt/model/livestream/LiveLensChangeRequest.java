package com.autel.great.mqtt.model.livestream;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.livestream.LensChangeVideoTypeEnum;
import com.autel.great.mqtt.model.device.VideoId;

import javax.validation.constraints.NotNull;

public class LiveLensChangeRequest extends BaseModel {

    @NotNull
    private LensChangeVideoTypeEnum videoType;

    @NotNull
    private VideoId videoId;

    public LiveLensChangeRequest() {
    }

    @Override
    public String toString() {
        return "LiveLensChangeRequest{" +
                "videoType=" + videoType +
                ", videoId=" + videoId +
                '}';
    }

    public LensChangeVideoTypeEnum getVideoType() {
        return videoType;
    }

    public LiveLensChangeRequest setVideoType(LensChangeVideoTypeEnum videoType) {
        this.videoType = videoType;
        return this;
    }

    public VideoId getVideoId() {
        return videoId;
    }

    public LiveLensChangeRequest setVideoId(VideoId videoId) {
        this.videoId = videoId;
        return this;
    }
}
