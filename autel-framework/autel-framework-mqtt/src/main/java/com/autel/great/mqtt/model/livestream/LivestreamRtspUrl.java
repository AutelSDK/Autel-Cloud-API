package com.autel.great.mqtt.model.livestream;


import com.autel.great.context.base.BaseModel;

import javax.validation.constraints.NotNull;

public class LivestreamRtspUrl extends BaseModel implements ILivestreamUrl {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Integer port;

    public LivestreamRtspUrl() {
    }

    @Override
    public String toString() {
        return "userName=" + username +
                "&password=" + password +
                "&port=" + port;
    }

    @Override
    public LivestreamRtspUrl clone() {
        try {
            return (LivestreamRtspUrl) super.clone();
        } catch (CloneNotSupportedException e) {
            return new LivestreamRtspUrl().setUsername(username).setPassword(password).setPort(port);
        }
    }

    public String getUsername() {
        return username;
    }

    public LivestreamRtspUrl setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LivestreamRtspUrl setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public LivestreamRtspUrl setPort(Integer port) {
        this.port = port;
        return this;
    }
}
