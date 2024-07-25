package com.autel.service.wayline.service;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.model.CustomClaim;
import com.autel.service.wayline.model.dto.ConditionalWaylineJobKey;
import com.autel.service.wayline.model.dto.WaylineJobDTO;
import com.autel.service.wayline.model.param.CreateJobParam;
import com.autel.service.wayline.model.param.UpdateJobParam;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface IFlightTaskService {

    HttpResultResponse publishFlightTask(CreateJobParam param, CustomClaim customClaim) throws SQLException;

    HttpResultResponse publishOneFlightTask(WaylineJobDTO waylineJob) throws SQLException;

    Boolean executeFlightTask(String workspaceId, String jobId);

    void cancelFlightTask(String workspaceId, Collection<String> jobIds);

    void publishCancelTask(String workspaceId, String dockSn, List<String> jobIds);

    void uploadMediaHighestPriority(String workspaceId, String jobId);

    void updateJobStatus(String workspaceId, String jobId, UpdateJobParam param);

    void retryPrepareJob(ConditionalWaylineJobKey jobKey, WaylineJobDTO waylineJob);
}
