package com.autel.service.manage.model.dto;

import com.autel.great.mqtt.model.tsa.TopologyList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceLogsDTO {

    private String logsId;

    private LocalDateTime happenTime;

    private String userName;

    private String logsInformation;

    private LocalDateTime createTime;

    private Integer status;

    private TopologyList deviceTopo;

    private List<LogsProgressDTO> logsProgress;

    private LogsFileUploadListDTO deviceLogs;

}
