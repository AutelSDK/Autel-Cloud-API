package com.autel.service.manage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeviceDictionaryDTO {

    private Integer domain;

    private Integer deviceType;

    private Integer subType;

    private String deviceName;

    private String deviceDesc;
}