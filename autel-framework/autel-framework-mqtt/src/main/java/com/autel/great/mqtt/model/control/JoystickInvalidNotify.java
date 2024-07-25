package com.autel.great.mqtt.model.control;

import com.autel.great.mqtt.enums.control.JoystickInvalidReasonEnum;

public class JoystickInvalidNotify {

    private JoystickInvalidReasonEnum reason;

    public JoystickInvalidNotify() {
    }

    @Override
    public String toString() {
        return "JoystickInvalidNotify{" +
                "reason=" + reason +
                '}';
    }

    public JoystickInvalidReasonEnum getReason() {
        return reason;
    }

    public JoystickInvalidNotify setReason(JoystickInvalidReasonEnum reason) {
        this.reason = reason;
        return this;
    }
}
