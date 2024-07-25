package com.autel.service.manage.controller;

import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.web.core.AuthInterceptor;
import com.autel.service.manage.model.dto.CapacityDeviceDTO;
import com.autel.service.manage.model.dto.LiveTypeDTO;
import com.autel.service.manage.service.ILiveStreamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("${url.manage.prefix}${url.manage.version}/live")
public class LiveStreamController {

    @Autowired
    private ILiveStreamService liveStreamService;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/capacity")
    public HttpResultResponse<List<CapacityDeviceDTO>> getLiveCapacity(HttpServletRequest request) {
        CustomClaim customClaim = (CustomClaim)request.getAttribute(AuthInterceptor.TOKEN_CLAIM);
        List<CapacityDeviceDTO> liveCapacity = liveStreamService.getLiveCapacity(customClaim.getWorkspaceId());
        return HttpResultResponse.success(liveCapacity);
    }

    @PostMapping("/streams/start")
    public HttpResultResponse liveStart(@RequestBody LiveTypeDTO liveParam) {
        return liveStreamService.liveStart(liveParam);
    }

    @PostMapping("/streams/stop")
    public HttpResultResponse liveStop(@RequestBody LiveTypeDTO liveParam) {
        return liveStreamService.liveStop(liveParam.getVideoId());
    }

    @PostMapping("/streams/update")
    public HttpResultResponse liveSetQuality(@RequestBody LiveTypeDTO liveParam) {
        return liveStreamService.liveSetQuality(liveParam);
    }

    @PostMapping("/streams/switch")
    public HttpResultResponse liveLensChange(@RequestBody LiveTypeDTO liveParam) {
        return liveStreamService.liveLensChange(liveParam);
    }

}