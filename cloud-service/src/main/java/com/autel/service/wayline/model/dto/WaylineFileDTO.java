package com.autel.service.wayline.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaylineFileDTO {

    private String name;

    @JsonProperty("id")
    private String waylineId;

    private String droneModelKey;

    private String sign;

    private List<String> payloadModelKeys;

    private Boolean favorited;

    private List<Integer> templateTypes;

    private String objectKey;

    @JsonProperty("user_name")
    private String username;

    private Long updateTime;
}
