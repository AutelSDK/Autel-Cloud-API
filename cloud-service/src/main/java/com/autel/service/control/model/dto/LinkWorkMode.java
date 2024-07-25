package com.autel.service.control.model.dto;

import com.autel.great.mqtt.enums.device.LinkWorkModeEnum;
import com.autel.service.control.service.impl.RemoteDebugHandler;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class LinkWorkMode extends RemoteDebugHandler {

    private LinkWorkModeEnum linkWorkMode;

    @JsonCreator
    public LinkWorkMode(@JsonProperty("action") Integer linkWorkMode) {
        this.linkWorkMode = LinkWorkModeEnum.find(linkWorkMode);
    }

    @JsonValue
    public Map toMap() {
        return Map.of("link_workmode", linkWorkMode.getMode());
    }
}
