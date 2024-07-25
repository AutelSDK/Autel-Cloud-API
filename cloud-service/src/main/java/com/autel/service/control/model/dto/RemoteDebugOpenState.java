package com.autel.service.control.model.dto;

import com.autel.great.context.utils.SpringBeanUtilsTest;
import com.autel.great.mqtt.enums.device.DockModeCodeEnum;
import com.autel.service.control.service.impl.RemoteDebugHandler;
import com.autel.service.manage.service.IDeviceService;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
public class RemoteDebugOpenState extends RemoteDebugHandler {

    @Override
    public boolean canPublish(String sn) {
        IDeviceService deviceService = SpringBeanUtilsTest.getBean(IDeviceService.class);
        DockModeCodeEnum dockMode = deviceService.getDockMode(sn);
        return DockModeCodeEnum.IDLE == dockMode;
    }
}
