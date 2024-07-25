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
public class CapacityVideoDTO {

    private String id;

    private String index;

    private String type;

    private List<String> switchVideoTypes;
}