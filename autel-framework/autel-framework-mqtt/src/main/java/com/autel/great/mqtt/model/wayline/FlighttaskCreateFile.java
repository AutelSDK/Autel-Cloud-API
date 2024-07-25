package com.autel.great.mqtt.model.wayline;

import javax.validation.constraints.NotNull;

public class FlighttaskCreateFile {

    /**
     * File URL
     */
    @NotNull
    private String url;

    /**
     * MD5 signature
     */
    @NotNull
    private String sign;

    public FlighttaskCreateFile() {}

    @Override
    public String toString() {
        return "FlighttaskCreateFile{" +
                "url='" + url + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public FlighttaskCreateFile setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public FlighttaskCreateFile setSign(String sign) {
        this.sign = sign;
        return this;
    }
}