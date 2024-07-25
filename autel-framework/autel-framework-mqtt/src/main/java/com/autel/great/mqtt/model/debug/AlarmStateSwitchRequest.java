package com.autel.great.mqtt.model.debug;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.device.SwitchActionEnum;

import javax.validation.constraints.NotNull;

public class AlarmStateSwitchRequest extends BaseModel {

    @NotNull
    private SwitchActionEnum action;

    public AlarmStateSwitchRequest() {
    }

    @Override
    public String toString() {
        return "AlarmStateSwitchRequest{" +
                "action=" + action +
                '}';
    }

    public SwitchActionEnum getAction() {
        return action;
    }

    public AlarmStateSwitchRequest setAction(SwitchActionEnum action) {
        this.action = action;
        return this;
    }
}
