package com.autel.service.manage.model.receiver;

import com.autel.great.mqtt.model.log.FileUploadProgressExt;
import lombok.Data;

@Data
public class OutputLogsProgressReceiver {

    private FileUploadProgressExt ext;

    private String status;
}
