package com.autel.great.mqtt.model.log;


import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.log.LogModuleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class FileUploadListRequest extends BaseModel {

    /**
     * Filter list of file
     **/
    @NotNull
    @Size(min = 1, max = 2)
    private List<LogModuleEnum> moduleList;

    public FileUploadListRequest() {
    }

    @Override
    public String toString() {
        return "FileUploadListRequest{" +
                "moduleList=" + moduleList +
                '}';
    }

    public List<LogModuleEnum> getModuleList() {
        return moduleList;
    }

    public FileUploadListRequest setModuleList(List<LogModuleEnum> moduleList) {
        this.moduleList = moduleList;
        return this;
    }
}
