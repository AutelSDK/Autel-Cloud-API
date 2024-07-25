package com.autel.service.control.service;

import com.autel.great.mqtt.property.DrcModeMqttBroker;
import com.autel.service.control.model.dto.JwtAclDTO;
import com.autel.service.control.model.param.DrcConnectParam;
import com.autel.service.control.model.param.DrcModeParam;

public interface IDrcService {

    void setDrcModeInRedis(String dockSn, String clientId);

    String getDrcModeInRedis(String dockSn);

    Boolean delDrcModeInRedis(String dockSn);

    DrcModeMqttBroker userDrcAuth(String workspaceId, String userId, String username, DrcConnectParam param);

    JwtAclDTO deviceDrcEnter(String workspaceId, DrcModeParam param);

    void deviceDrcExit(String workspaceId, DrcModeParam param);
}
