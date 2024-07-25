package com.autel.service.manage.service;

import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.context.page.PaginationData;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.enums.control.ControlSourceEnum;
import com.autel.great.mqtt.enums.device.DockModeCodeEnum;
import com.autel.great.mqtt.enums.device.DroneModeCodeEnum;
import com.autel.great.mqtt.model.device.DeviceOsdHost;
import com.autel.great.websocket.enums.BizCodeEnum;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.model.dto.DeviceFirmwareUpgradeDTO;
import com.autel.service.manage.model.dto.TopologyDeviceDTO;
import com.autel.service.manage.model.param.DeviceQueryParam;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Optional;

public interface IDeviceService {

    void subDeviceOffline(String deviceSn);

    void gatewayOffline(String gatewaySn);

    void gatewayOnlineSubscribeTopic(GatewayManager gateway);

    void subDeviceOnlineSubscribeTopic(GatewayManager gateway);

    void offlineUnsubscribeTopic(GatewayManager gateway);

    List<DeviceDTO> getDevicesByParams(DeviceQueryParam param);

    List<DeviceDTO> getDevicesTopoForWeb(String workspaceId);

    void spliceDeviceTopo(DeviceDTO device);

    Optional<TopologyDeviceDTO> getDeviceTopoForPilot(String sn);

    TopologyDeviceDTO deviceConvertToTopologyDTO(DeviceDTO device);

    void pushDeviceOfflineTopo(String workspaceId, String deviceSn);

    void pushDeviceOnlineTopo(String workspaceId, String gatewaySn, String deviceSn);

    Boolean updateDevice(DeviceDTO deviceDTO);

    Boolean bindDevice(DeviceDTO device);

    PaginationData<DeviceDTO> getBoundDevicesWithDomain(String workspaceId, Long page, Long pageSize, Integer domain);

    void unbindDevice(String deviceSn);

    Optional<DeviceDTO> getDeviceBySn(String sn);

    HttpResultResponse createDeviceOtaJob(String workspaceId, List<DeviceFirmwareUpgradeDTO> upgradeDTOS);

    int devicePropertySet(String workspaceId, String dockSn, JsonNode param);

    DockModeCodeEnum getDockMode(String dockSn);

    DroneModeCodeEnum getDeviceMode(String deviceSn);

    Boolean checkDockDrcMode(String dockSn);

    Boolean checkAuthorityFlight(String gatewaySn);

    Integer saveDevice(DeviceDTO device);

    Boolean saveOrUpdateDevice(DeviceDTO device);

    void pushOsdDataToPilot(String workspaceId, String sn, DeviceOsdHost data);

    void pushOsdDataToWeb(String workspaceId, BizCodeEnum codeEnum, String sn, Object data);

    void updateFlightControl(DeviceDTO gateway, ControlSourceEnum controlSource);
}