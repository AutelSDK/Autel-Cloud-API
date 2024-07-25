package com.autel.service.manage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CapacityDeviceDTO {

    private String sn;

    private String name;

    private List<CapacityCameraDTO> camerasList;
}