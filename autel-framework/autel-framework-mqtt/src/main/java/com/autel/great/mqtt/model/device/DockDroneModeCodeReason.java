package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.ModeCodeReasonEnum;

public class DockDroneModeCodeReason {

    private ModeCodeReasonEnum modeCodeReason;

    public DockDroneModeCodeReason() {
    }

    @Override
    public String toString() {
        return "DockDroneModeCodeReason{" +
                "modeCodeReason=" + modeCodeReason +
                '}';
    }

    public ModeCodeReasonEnum getModeCodeReason() {
        return modeCodeReason;
    }

    public DockDroneModeCodeReason setModeCodeReason(ModeCodeReasonEnum modeCodeReason) {
        this.modeCodeReason = modeCodeReason;
        return this;
    }
}
