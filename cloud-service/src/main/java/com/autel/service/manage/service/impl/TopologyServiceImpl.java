package com.autel.service.manage.service.impl;

import com.autel.great.context.enums.device.DeviceDomainEnum;
import com.autel.great.mqtt.model.tsa.DeviceTopology;
import com.autel.great.mqtt.model.tsa.TopologyList;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.model.dto.TopologyDeviceDTO;
import com.autel.service.manage.model.param.DeviceQueryParam;
import com.autel.service.manage.service.IDeviceService;
import com.autel.service.manage.service.ITopologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopologyServiceImpl implements ITopologyService {

    @Autowired
    private IDeviceService deviceService;

    @Override
    public List<TopologyList> getDeviceTopology(String workspaceId) {
        // Query the information of all gateway devices in the workspace.
        List<DeviceDTO> gatewayList = deviceService.getDevicesByParams(
                DeviceQueryParam.builder()
                        .workspaceId(workspaceId)
                        .domains(List.of(DeviceDomainEnum.REMOTER_CONTROL.getDomain()))
                        .build());

        List<TopologyList> topologyList = new ArrayList<>();

        gatewayList.forEach(device -> this.getDeviceTopologyByGatewaySn(device.getDeviceSn())
                .ifPresent(topologyList::add));

        return topologyList;
    }

    public Optional<TopologyList> getDeviceTopologyByGatewaySn(String gatewaySn) {
        Optional<DeviceDTO> dtoOptional = deviceService.getDeviceBySn(gatewaySn);
        if (dtoOptional.isEmpty()) {
            return Optional.empty();
        }
        List<DeviceTopology> parents = new ArrayList<>();
        DeviceDTO device = dtoOptional.get();
        DeviceTopology gateway = deviceService.deviceConvertToTopologyDTO(device);
        parents.add(gateway);

        // Query the topology data of the drone based on the drone sn.
        Optional<TopologyDeviceDTO> deviceTopo = deviceService.getDeviceTopoForPilot(device.getChildDeviceSn());
        List<DeviceTopology> deviceTopoList = new ArrayList<>();
        deviceTopo.ifPresent(deviceTopoList::add);

        return Optional.ofNullable(new TopologyList().setParents(parents).setHosts(deviceTopoList));
    }

}
