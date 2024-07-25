package com.autel.service.map.controller;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.web.core.AuthInterceptor;
import com.autel.service.map.model.dto.FlightAreaDTO;
import com.autel.service.map.model.param.PostFlightAreaParam;
import com.autel.service.map.model.param.PutFlightAreaParam;
import com.autel.service.map.model.param.SyncFlightAreaParam;
import com.autel.service.map.service.IFlightAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${url.map.prefix}${url.map.version}/workspaces")
public class FlightAreaController {

    @Autowired
    private IFlightAreaService flightAreaService;

    @GetMapping("/{workspace_id}/flight-areas")
    public HttpResultResponse<List<FlightAreaDTO>> getFlightAreas(@PathVariable(name = "workspace_id") String workspaceId) {
        return HttpResultResponse.success(flightAreaService.getFlightAreaList(workspaceId));
    }

    @PostMapping("/{workspace_id}/flight-area")
    public HttpResultResponse createFlightArea(@PathVariable(name = "workspace_id") String workspaceId,
                                               @Valid @RequestBody PostFlightAreaParam param, HttpServletRequest req) {
        CustomClaim claims = (CustomClaim) req.getAttribute(AuthInterceptor.TOKEN_CLAIM);
        flightAreaService.createFlightArea(workspaceId, claims.getUsername(), param);
        return HttpResultResponse.success();
    }

    @DeleteMapping("/{workspace_id}/flight-area/{area_id}")
    public HttpResultResponse deleteFlightArea(@PathVariable(name = "workspace_id") String workspaceId,
                                               @PathVariable(name = "area_id") String areaId) {
        flightAreaService.deleteFlightArea(workspaceId, areaId);
        return HttpResultResponse.success();
    }

    @PutMapping("/{workspace_id}/flight-area/{area_id}")
    public HttpResultResponse updateFlightArea(@PathVariable(name = "workspace_id") String workspaceId,
                                               @PathVariable(name = "area_id") String areaId,
                                               @RequestBody PutFlightAreaParam param) {
        flightAreaService.updateFlightArea(workspaceId, areaId, param);
        return HttpResultResponse.success();
    }

    @PostMapping("/{workspace_id}/flight-area/sync")
    public HttpResultResponse syncFlightArea(@PathVariable(name = "workspace_id") String workspaceId,
                                             @RequestBody @Valid SyncFlightAreaParam param) {
        flightAreaService.syncFlightArea(workspaceId, param.getDeviceSns());
        return HttpResultResponse.success();
    }

}
