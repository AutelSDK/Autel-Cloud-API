package com.autel.service.manage.model.receiver;

import lombok.Data;

import java.util.List;

@Data
public class LiveCapacityReceiver {

    private Integer availableVideoNumber;

    private Integer coexistVideoNumberMax;

    private List<CapacityDeviceReceiver> deviceList;
}
