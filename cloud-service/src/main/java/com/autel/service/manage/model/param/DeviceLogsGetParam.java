package com.autel.service.manage.model.param;

import com.autel.great.mqtt.enums.log.LogModuleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class DeviceLogsGetParam {

    @JsonProperty("domain_list")
    List<LogModuleEnum> domainList;
}
