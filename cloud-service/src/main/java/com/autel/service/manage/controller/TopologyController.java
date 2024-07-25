package com.autel.service.manage.controller;

import com.autel.api.tsa.IHttpTsaService;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.model.tsa.TopologyList;
import com.autel.great.mqtt.model.tsa.TopologyResponse;
import com.autel.service.manage.service.ITopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class TopologyController implements IHttpTsaService {

    @Autowired
    private ITopologyService topologyService;


    @Override
    public HttpResultResponse<TopologyResponse> obtainDeviceTopologyList(String workspaceId, HttpServletRequest req, HttpServletResponse rsp) {
        List<TopologyList> topologyList = topologyService.getDeviceTopology(workspaceId);
        return HttpResultResponse.success(new TopologyResponse().setList(topologyList));
    }
}
