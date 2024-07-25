package com.autel.service.manage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CapacityCameraDTO {

    private String id;

    private String deviceSn;

    private String name;

    private String index;

    private String type;

    private List<CapacityVideoDTO> videosList;
}