package com.autel.great.mqtt.model.livestream;


import com.autel.great.mqtt.model.device.PayloadIndex;

import java.util.List;

public class RcLiveCapacityCamera {

    /**
     * Total number of video streams that can be used for livestreaming
     * Total number of video streams that the camera can live stream
     */
    private Integer availableVideoNumber;

    /**
     * Maximum number of video streams that the camera can live stream at the same time.
     */
    private Integer coexistVideoNumberMax;

    /**
     * Camera index, composed of product type enumeration and gimbal index.
     */
    private PayloadIndex cameraIndex;

    private List<RcLiveCapacityVideo> videoList;

    public RcLiveCapacityCamera() {
    }

    @Override
    public String toString() {
        return "RcLiveCapacityCamera{" +
                "availableVideoNumber=" + availableVideoNumber +
                ", coexistVideoNumberMax=" + coexistVideoNumberMax +
                ", cameraIndex=" + cameraIndex +
                ", videoList=" + videoList +
                '}';
    }

    public Integer getAvailableVideoNumber() {
        return availableVideoNumber;
    }

    public RcLiveCapacityCamera setAvailableVideoNumber(Integer availableVideoNumber) {
        this.availableVideoNumber = availableVideoNumber;
        return this;
    }

    public Integer getCoexistVideoNumberMax() {
        return coexistVideoNumberMax;
    }

    public RcLiveCapacityCamera setCoexistVideoNumberMax(Integer coexistVideoNumberMax) {
        this.coexistVideoNumberMax = coexistVideoNumberMax;
        return this;
    }

    public PayloadIndex getCameraIndex() {
        return cameraIndex;
    }

    public RcLiveCapacityCamera setCameraIndex(PayloadIndex cameraIndex) {
        this.cameraIndex = cameraIndex;
        return this;
    }

    public List<RcLiveCapacityVideo> getVideoList() {
        return videoList;
    }

    public RcLiveCapacityCamera setVideoList(List<RcLiveCapacityVideo> videoList) {
        this.videoList = videoList;
        return this;
    }
}