package com.autel.service.manage.model.dto;

import com.autel.great.mqtt.enums.control.ControlSourceEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DevicePayloadReceiver {

    private String deviceSn;

    private ControlSourceEnum controlSource;

    private PayloadIndex payloadIndex;

    private String sn;

}