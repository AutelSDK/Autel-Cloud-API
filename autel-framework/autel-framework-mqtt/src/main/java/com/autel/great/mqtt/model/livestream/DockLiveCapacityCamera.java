package com.autel.great.mqtt.model.livestream;


import com.autel.great.mqtt.model.device.PayloadIndex;

import java.util.List;

public class DockLiveCapacityCamera {

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

    private List<DockLiveCapacityVideo> videoList;

    public DockLiveCapacityCamera() {
    }

    @Override
    public String toString() {
        return "DockLiveCapacityCamera{" +
                "availableVideoNumber=" + availableVideoNumber +
                ", coexistVideoNumberMax=" + coexistVideoNumberMax +
                ", cameraIndex=" + cameraIndex +
                ", videoList=" + videoList +
                '}';
    }

    public Integer getAvailableVideoNumber() {
        return availableVideoNumber;
    }

    public DockLiveCapacityCamera setAvailableVideoNumber(Integer availableVideoNumber) {
        this.availableVideoNumber = availableVideoNumber;
        return this;
    }

    public Integer getCoexistVideoNumberMax() {
        return coexistVideoNumberMax;
    }

    public DockLiveCapacityCamera setCoexistVideoNumberMax(Integer coexistVideoNumberMax) {
        this.coexistVideoNumberMax = coexistVideoNumberMax;
        return this;
    }

    public PayloadIndex getCameraIndex() {
        return cameraIndex;
    }

    public DockLiveCapacityCamera setCameraIndex(PayloadIndex cameraIndex) {
        this.cameraIndex = cameraIndex;
        return this;
    }

    public List<DockLiveCapacityVideo> getVideoList() {
        return videoList;
    }

    public DockLiveCapacityCamera setVideoList(List<DockLiveCapacityVideo> videoList) {
        this.videoList = videoList;
        return this;
    }
}