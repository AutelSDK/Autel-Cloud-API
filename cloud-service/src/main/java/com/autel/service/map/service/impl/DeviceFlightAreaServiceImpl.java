package com.autel.service.map.service.impl;

import com.autel.great.mqtt.enums.flightarea.FlightAreaSyncReasonEnum;
import com.autel.great.mqtt.enums.flightarea.FlightAreaSyncStatusEnum;
import com.autel.service.map.dao.IDeviceFlightAreaMapper;
import com.autel.service.map.model.dto.DeviceFlightAreaDTO;
import com.autel.service.map.model.entity.DeviceFlightAreaEntity;
import com.autel.service.map.service.IDeviceFlightAreaService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class DeviceFlightAreaServiceImpl implements IDeviceFlightAreaService {

    @Autowired
    private IDeviceFlightAreaMapper mapper;

    @Override
    public Optional<DeviceFlightAreaDTO> getDeviceFlightAreaByDevice(String workspaceId, String deviceSn) {
        return Optional.ofNullable(mapper.selectOne(Wrappers.lambdaQuery(DeviceFlightAreaEntity.class)
                        .eq(DeviceFlightAreaEntity::getWorkspaceId, workspaceId)
                        .eq(DeviceFlightAreaEntity::getDeviceSn, deviceSn)))
                .map(this::entity2Dto);
    }

    @Override
    public Boolean updateDeviceFile(DeviceFlightAreaDTO deviceFile) {
        return mapper.update(dto2Entity(deviceFile),
                Wrappers.lambdaUpdate(DeviceFlightAreaEntity.class)
                        .eq(DeviceFlightAreaEntity::getWorkspaceId, deviceFile.getWorkspaceId())
                        .eq(DeviceFlightAreaEntity::getDeviceSn, deviceFile.getDeviceSn())) > 0;
    }

    @Override
    public Boolean updateOrSaveDeviceFile(DeviceFlightAreaDTO deviceFile) {
        if (getDeviceFlightAreaByDevice(deviceFile.getWorkspaceId(), deviceFile.getDeviceSn()).isPresent()) {
            return updateDeviceFile(deviceFile);
        }
        DeviceFlightAreaEntity entity = dto2Entity(deviceFile);
        entity.setFileId(UUID.randomUUID().toString());
        return mapper.insert(entity) > 0;
    }

    private DeviceFlightAreaEntity dto2Entity(DeviceFlightAreaDTO dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return DeviceFlightAreaEntity.builder()
                .deviceSn(dto.getDeviceSn())
                .workspaceId(dto.getWorkspaceId())
                .fileId(dto.getFileId())
                .syncCode(dto.getSyncCode().getReason())
                .syncStatus(dto.getSyncStatus().getStatus())
                .build();
    }

    private DeviceFlightAreaDTO entity2Dto(DeviceFlightAreaEntity entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        FlightAreaSyncReasonEnum syncCodeEnum = FlightAreaSyncReasonEnum.find(entity.getSyncCode());
        return DeviceFlightAreaDTO.builder()
                .deviceSn(entity.getDeviceSn())
                .workspaceId(entity.getWorkspaceId())
                .fileId(entity.getFileId())
                .syncCode(syncCodeEnum)
                .syncStatus(FlightAreaSyncStatusEnum.find(entity.getSyncStatus()))
                .syncMsg(syncCodeEnum.getMsg())
                .build();
    }


}
