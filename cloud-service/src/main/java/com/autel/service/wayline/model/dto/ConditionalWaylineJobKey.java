package com.autel.service.wayline.model.dto;

import com.autel.great.redis.RedisConst;
import lombok.Data;

import java.util.Objects;

@Data
public class ConditionalWaylineJobKey {

    private String workspaceId;

    private String dockSn;

    private String jobId;

    public ConditionalWaylineJobKey(String workspaceId, String dockSn, String jobId) {
        this.workspaceId = workspaceId;
        this.dockSn = dockSn;
        this.jobId = jobId;
    }

    public ConditionalWaylineJobKey(String key) {
        if (Objects.isNull(key)) {
            return;
        }
        String[] keyArr = key.split(RedisConst.DELIMITER);
        new ConditionalWaylineJobKey(keyArr[0], keyArr[1], keyArr[2]);
    }

    public String getKey() {
        return String.join(RedisConst.DELIMITER, workspaceId, dockSn, jobId);
    }
}
