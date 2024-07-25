package com.autel.service.manage.model.receiver;

import com.autel.great.mqtt.enums.device.RcLostActionEnum;
import com.autel.great.mqtt.model.device.OsdDockDrone;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class OutOfControlActionReceiver extends BasicDeviceProperty {

    private RcLostActionEnum rcLostAction;

    @JsonCreator
    public OutOfControlActionReceiver(Integer rcLostAction) {
        this.rcLostAction = RcLostActionEnum.find(rcLostAction);
    }

    @Override
    public boolean valid() {
        return Objects.nonNull(rcLostAction);
    }

    @Override
    public boolean canPublish(OsdDockDrone osd) {
        return rcLostAction != osd.getRcLostAction();
    }
}
