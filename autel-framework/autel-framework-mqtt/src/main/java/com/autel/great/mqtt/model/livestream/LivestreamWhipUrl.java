package com.autel.great.mqtt.model.livestream;


import com.autel.great.context.base.BaseModel;

import javax.validation.constraints.NotNull;

public class LivestreamWhipUrl extends BaseModel implements ILivestreamUrl {

    @NotNull
    private String url;

    public LivestreamWhipUrl() {
    }

    @Override
    public String toString() {
        return url;
    }

    @Override
    public LivestreamWhipUrl clone() {
        try {
            return (LivestreamWhipUrl) super.clone();
        } catch (CloneNotSupportedException e) {
            return new LivestreamWhipUrl().setUrl(url);
        }
    }

    public String getUrl() {
        return url;
    }

    public LivestreamWhipUrl setUrl(String url) {
        this.url = url;
        return this;
    }
}
