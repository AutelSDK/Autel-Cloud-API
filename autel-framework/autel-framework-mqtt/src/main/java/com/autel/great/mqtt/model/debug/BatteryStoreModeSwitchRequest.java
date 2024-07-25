package com.autel.great.mqtt.model.debug;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.device.BatteryStoreModeEnum;

import javax.validation.constraints.NotNull;

public class BatteryStoreModeSwitchRequest extends BaseModel {

    @NotNull
    private BatteryStoreModeEnum action;

    public BatteryStoreModeSwitchRequest() {
    }

    @Override
    public String toString() {
        return "BatteryStoreModeSwitchRequest{" +
                "action=" + action +
                '}';
    }

    public BatteryStoreModeEnum getAction() {
        return action;
    }

    public BatteryStoreModeSwitchRequest setAction(BatteryStoreModeEnum action) {
        this.action = action;
        return this;
    }
}
