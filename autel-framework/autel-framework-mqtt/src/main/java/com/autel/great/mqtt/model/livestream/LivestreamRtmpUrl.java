package com.autel.great.mqtt.model.livestream;


import com.autel.great.context.base.BaseModel;

import javax.validation.constraints.NotNull;

public class LivestreamRtmpUrl extends BaseModel implements ILivestreamUrl {

    @NotNull
    private String url;
    @NotNull
    private String payUrl;

    public LivestreamRtmpUrl() {
    }

    @Override
    public String toString() {
        return url;
    }

    @Override
    public LivestreamRtmpUrl clone() {
        try {
            return (LivestreamRtmpUrl) super.clone();
        } catch (CloneNotSupportedException e) {
            LivestreamRtmpUrl livestreamRtmpUrl = new LivestreamRtmpUrl();
            livestreamRtmpUrl.setUrl(url);
            livestreamRtmpUrl.setPayUrl(payUrl);
            return livestreamRtmpUrl;
        }
    }

    public LivestreamRtmpUrl setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public LivestreamRtmpUrl setPayUrl(String url) {
        this.payUrl = url;
        return this;
    }

    public String getPayUrl() {
        return payUrl;
    }
}
