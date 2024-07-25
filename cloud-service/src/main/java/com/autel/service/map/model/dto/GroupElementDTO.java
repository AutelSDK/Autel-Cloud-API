package com.autel.service.map.model.dto;

import com.autel.great.mqtt.model.map.ElementResource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupElementDTO {

    @JsonProperty("id")
    private String elementId;

    private String name;

    @JsonProperty(value = "create_time")
    private Long createTime;

    @JsonProperty(value = "update_time")
    private Long updateTime;

    private ElementResource resource;

    @JsonProperty("group_id")
    private String groupId;
}
