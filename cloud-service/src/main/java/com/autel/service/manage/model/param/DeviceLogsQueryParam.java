package com.autel.service.manage.model.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeviceLogsQueryParam {

    private Long page;

    @JsonProperty("page_size")
    private Long pageSize;

    private Integer status;

    @JsonProperty("begin_time")
    private Long beginTime;

    @JsonProperty("end_time")
    private Long endTime;

    @JsonProperty("logs_information")
    private String logsInformation;
}
