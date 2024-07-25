package com.autel.service.control.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultNotifyDTO {

    private Integer result;

    private String message;

    private String sn;
}
