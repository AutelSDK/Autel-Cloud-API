package com.autel.service.wayline.controller;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.page.PaginationData;
import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.web.core.AuthInterceptor;
import com.autel.service.wayline.model.param.CreateJobParam;
import com.autel.service.wayline.model.param.UpdateJobParam;
import com.autel.service.wayline.service.IFlightTaskService;
import com.autel.service.wayline.service.IWaylineJobService;
import com.autel.service.wayline.model.dto.WaylineJobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Set;

@RequestMapping("${url.wayline.prefix}${url.wayline.version}/workspaces")
@RestController
public class WaylineJobController {

    @Autowired
    private IWaylineJobService waylineJobService;

    @Autowired
    private IFlightTaskService flighttaskService;

    @PostMapping("/{workspace_id}/flight-tasks")
    public HttpResultResponse createJob(HttpServletRequest request, @Valid @RequestBody CreateJobParam param,
                                        @PathVariable(name = "workspace_id") String workspaceId) throws SQLException {
        CustomClaim customClaim = (CustomClaim)request.getAttribute(AuthInterceptor.TOKEN_CLAIM);
        customClaim.setWorkspaceId(workspaceId);

        return flighttaskService.publishFlightTask(param, customClaim);
    }

    @GetMapping("/{workspace_id}/jobs")
    public HttpResultResponse<PaginationData<WaylineJobDTO>> getJobs(@RequestParam(defaultValue = "1") Long page,
                                                                     @RequestParam(name = "page_size", defaultValue = "10") Long pageSize,
                                                                     @PathVariable(name = "workspace_id") String workspaceId) {
        PaginationData<WaylineJobDTO> data = waylineJobService.getJobsByWorkspaceId(workspaceId, page, pageSize);
        return HttpResultResponse.success(data);
    }

    @DeleteMapping("/{workspace_id}/jobs")
    public HttpResultResponse publishCancelJob(@RequestParam(name = "job_id") Set<String> jobIds,
                                               @PathVariable(name = "workspace_id") String workspaceId) throws SQLException {
        flighttaskService.cancelFlightTask(workspaceId, jobIds);
        return HttpResultResponse.success();
    }

    @PostMapping("/{workspace_id}/jobs/{job_id}/media-highest")
    public HttpResultResponse uploadMediaHighestPriority(@PathVariable(name = "workspace_id") String workspaceId,
                                                         @PathVariable(name = "job_id") String jobId) {
        flighttaskService.uploadMediaHighestPriority(workspaceId, jobId);
        return HttpResultResponse.success();
    }

    @PutMapping("/{workspace_id}/jobs/{job_id}")
    public HttpResultResponse updateJobStatus(@PathVariable(name = "workspace_id") String workspaceId,
                                              @PathVariable(name = "job_id") String jobId,
                                              @Valid @RequestBody UpdateJobParam param) {
        flighttaskService.updateJobStatus(workspaceId, jobId, param);
        return HttpResultResponse.success();
    }
}
