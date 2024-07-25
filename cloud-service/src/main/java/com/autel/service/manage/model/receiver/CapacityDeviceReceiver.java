package com.autel.service.manage.model.receiver;

import lombok.Data;

import java.util.List;

@Data
public class CapacityDeviceReceiver {

    private String sn;

    private Integer availableVideoNumber;

    private Integer coexistVideoNumberMax;

    private List<CapacityCameraReceiver> cameraList;

}