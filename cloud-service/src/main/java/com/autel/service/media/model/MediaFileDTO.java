package com.autel.service.media.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediaFileDTO {

    private String fileId;

    private String fileName;

    private String filePath;

    private String objectKey;

    private String subFileType;

    private Boolean isOriginal;

    private String drone;

    private String payload;

    private String tinnyFingerprint;

    private String fingerprint;

    private LocalDateTime createTime;

    private String jobId;
}
