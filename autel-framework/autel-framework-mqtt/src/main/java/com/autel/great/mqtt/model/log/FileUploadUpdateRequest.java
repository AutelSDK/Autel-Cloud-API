package com.autel.great.mqtt.model.log;


import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.log.FileUploadUpdateStatusEnum;
import com.autel.great.mqtt.enums.log.LogModuleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class FileUploadUpdateRequest extends BaseModel {

    /**
     * Filter list of file
     **/
    @NotNull
    @Size(min = 1, max = 2)
    private List<LogModuleEnum> moduleList;

    @NotNull
    private FileUploadUpdateStatusEnum status;

    public FileUploadUpdateRequest() {
    }

    @Override
    public String toString() {
        return "FileUploadUpdateRequest{" +
                "moduleList=" + moduleList +
                ", status=" + status +
                '}';
    }

    public List<LogModuleEnum> getModuleList() {
        return moduleList;
    }

    public FileUploadUpdateRequest setModuleList(List<LogModuleEnum> moduleList) {
        this.moduleList = moduleList;
        return this;
    }

    public FileUploadUpdateStatusEnum getStatus() {
        return status;
    }

    public FileUploadUpdateRequest setStatus(FileUploadUpdateStatusEnum status) {
        this.status = status;
        return this;
    }
}
