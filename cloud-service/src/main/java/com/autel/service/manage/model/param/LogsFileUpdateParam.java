package com.autel.service.manage.model.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class LogsFileUpdateParam {

    private String status;

    @JsonProperty("module_list")
    private List<String> deviceModelDomainList;

}
