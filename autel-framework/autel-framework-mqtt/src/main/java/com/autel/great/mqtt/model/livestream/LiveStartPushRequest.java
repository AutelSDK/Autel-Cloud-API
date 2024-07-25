package com.autel.great.mqtt.model.livestream;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.livestream.UrlTypeEnum;
import com.autel.great.mqtt.enums.livestream.VideoQualityEnum;
import com.autel.great.mqtt.model.device.VideoId;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class LiveStartPushRequest extends BaseModel {

    @NotNull
    private UrlTypeEnum urlType;

    @NotNull
    @Valid
    private ILivestreamUrl url;

    @NotNull
    private VideoId videoId;

    @NotNull
    private VideoQualityEnum videoQuality;

    public LiveStartPushRequest() {
    }

    @Override
    public String toString() {
        return "LiveStartPushRequest{" +
                "urlType=" + urlType +
                ", url=" + url +
                ", videoId=" + videoId +
                ", videoQuality=" + videoQuality +
                '}';
    }

    public UrlTypeEnum getUrlType() {
        return urlType;
    }

    public LiveStartPushRequest setUrlType(UrlTypeEnum urlType) {
        this.urlType = urlType;
        return this;
    }

    public ILivestreamUrl getUrl() {
        return url;
    }

    public LiveStartPushRequest setUrl(ILivestreamUrl url) {
        this.url = url;
        return this;
    }

    public VideoId getVideoId() {
        return videoId;
    }

    public LiveStartPushRequest setVideoId(VideoId videoId) {
        this.videoId = videoId;
        return this;
    }

    public VideoQualityEnum getVideoQuality() {
        return videoQuality;
    }

    public LiveStartPushRequest setVideoQuality(VideoQualityEnum videoQuality) {
        this.videoQuality = videoQuality;
        return this;
    }
}
