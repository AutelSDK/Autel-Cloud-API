package com.autel.service.manage.model.dto;

import com.autel.great.mqtt.enums.log.FileUploadStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogsOutputProgressDTO {

    private String logsId;

    private FileUploadStatusEnum status;

    private List<LogsProgressDTO> files;
}
