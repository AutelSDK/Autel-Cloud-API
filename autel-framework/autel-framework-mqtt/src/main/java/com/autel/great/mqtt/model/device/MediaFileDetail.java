package com.autel.great.mqtt.model.device;

public class MediaFileDetail {

    private Integer remainUpload;

    public MediaFileDetail() {
    }

    @Override
    public String toString() {
        return "MediaFileDetail{" +
                "remainUpload=" + remainUpload +
                '}';
    }

    public Integer getRemainUpload() {
        return remainUpload;
    }

    public MediaFileDetail setRemainUpload(Integer remainUpload) {
        this.remainUpload = remainUpload;
        return this;
    }
}
