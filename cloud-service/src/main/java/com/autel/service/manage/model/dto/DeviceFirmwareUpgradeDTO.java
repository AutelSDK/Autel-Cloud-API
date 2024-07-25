package com.autel.service.manage.model.dto;

import lombok.Data;
@Data
public class DeviceFirmwareUpgradeDTO {

    private String deviceName;

    private String sn;

    private String productVersion;

    private Integer firmwareUpgradeType;
}
