package com.autel.service.manage.model.dto;

import com.autel.great.context.enums.device.DeviceDomainEnum;
import com.autel.great.context.enums.device.DeviceSubTypeEnum;
import com.autel.great.context.enums.device.DeviceTypeEnum;
import com.autel.great.mqtt.enums.control.ControlSourceEnum;
import com.autel.great.mqtt.model.tsa.DeviceIconUrl;
import com.autel.service.manage.model.enums.DeviceFirmwareStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceDTO {

    private String deviceSn;

    private String deviceName;

    private String workspaceId;

    private ControlSourceEnum controlSource;

    private String deviceDesc;

    private String childDeviceSn;

    private DeviceDomainEnum domain;

    private DeviceTypeEnum type;

    private DeviceSubTypeEnum subType;

    private List<DevicePayloadDTO> payloadsList;

    private DeviceIconUrl iconUrl;

    private Boolean status;

    private Boolean boundStatus;

    private LocalDateTime loginTime;

    private LocalDateTime boundTime;

    private String nickname;

    private String userId;

    private String firmwareVersion;

    private String workspaceName;

    private DeviceDTO children;

    private DeviceFirmwareStatusEnum firmwareStatus;

    private Integer firmwareProgress;

    private String parentSn;

    private String thingVersion;
}