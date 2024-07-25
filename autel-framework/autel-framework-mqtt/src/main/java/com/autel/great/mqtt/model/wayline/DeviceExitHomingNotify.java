package com.autel.great.mqtt.model.wayline;

import com.autel.great.mqtt.enums.wayline.ExitingRTHActionEnum;
import com.autel.great.mqtt.enums.wayline.ExitingRTHReasonEnum;

public class DeviceExitHomingNotify {

    private ExitingRTHActionEnum action;

    private String sn;

    private ExitingRTHReasonEnum reason;

    public DeviceExitHomingNotify() {
    }

    @Override
    public String toString() {
        return "DeviceExitHomingNotify{" +
                "action=" + action +
                ", sn='" + sn + '\'' +
                ", reason=" + reason +
                '}';
    }

    public ExitingRTHActionEnum getAction() {
        return action;
    }

    public DeviceExitHomingNotify setAction(ExitingRTHActionEnum action) {
        this.action = action;
        return this;
    }

    public String getSn() {
        return sn;
    }

    public DeviceExitHomingNotify setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public ExitingRTHReasonEnum getReason() {
        return reason;
    }

    public DeviceExitHomingNotify setReason(ExitingRTHReasonEnum reason) {
        this.reason = reason;
        return this;
    }
}
