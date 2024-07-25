package com.autel.service.media.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediaFileCountDTO {

    private String tid;

    private String bid;

    private String preJobId;

    private String jobId;

    private Integer mediaCount;

    private Integer uploadedCount;

    private String deviceSn;
}
