package com.autel.service.manage.model.dto;

import com.autel.great.mqtt.enums.log.LogModuleEnum;
import com.autel.great.mqtt.model.log.LogFileIndex;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogsFileUploadDTO {

    private String deviceSn;

    private List<LogFileIndex> list;

    @JsonProperty("module")
    private LogModuleEnum deviceModelDomain;

    private String objectKey;

    private Integer result;

    private String fileId;
}
