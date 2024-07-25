package com.autel.great.mqtt.model.debug;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.device.LinkWorkModeEnum;

import javax.validation.constraints.NotNull;

public class SdrWorkmodeSwitchRequest extends BaseModel {

    @NotNull
    private LinkWorkModeEnum linkWorkmode;

    public SdrWorkmodeSwitchRequest() {
    }

    @Override
    public String toString() {
        return "SdrWorkmodeSwitchRequest{" +
                "linkWorkmode=" + linkWorkmode +
                '}';
    }

    public LinkWorkModeEnum getLinkWorkmode() {
        return linkWorkmode;
    }

    public SdrWorkmodeSwitchRequest setLinkWorkmode(LinkWorkModeEnum linkWorkmode) {
        this.linkWorkmode = linkWorkmode;
        return this;
    }
}
