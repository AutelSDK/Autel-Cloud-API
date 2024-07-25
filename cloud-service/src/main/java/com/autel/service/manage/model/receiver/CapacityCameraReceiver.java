package com.autel.service.manage.model.receiver;

import com.autel.great.mqtt.model.device.PayloadIndex;
import lombok.Data;

import java.util.List;

@Data
public class CapacityCameraReceiver {

    private Integer availableVideoNumber;

    private Integer coexistVideoNumberMax;

    private PayloadIndex cameraIndex;

    private List<CapacityVideoReceiver> videoList;

}