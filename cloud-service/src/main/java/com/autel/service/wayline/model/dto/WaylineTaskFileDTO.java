package com.autel.service.wayline.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaylineTaskFileDTO {

    private String url;

    private String fingerprint;
}
