package com.autel.service.manage.model.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
public class DeviceFirmwareUploadParam {

    @NotNull
    @JsonProperty("release_note")
    private String releaseNote;
    
    @NotNull
    private Boolean status;

    @NotNull
    @JsonProperty("device_name")
    private List<String> deviceName;
}
