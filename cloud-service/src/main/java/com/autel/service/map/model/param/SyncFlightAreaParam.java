package com.autel.service.map.model.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SyncFlightAreaParam {

    @NotNull
    @JsonProperty("device_sn")
    private List<String> deviceSns;

}
