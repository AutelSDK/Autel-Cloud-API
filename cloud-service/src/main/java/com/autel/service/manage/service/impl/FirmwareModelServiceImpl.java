package com.autel.service.manage.service.impl;

import com.autel.service.manage.service.IFirmwareModelService;
import com.autel.service.manage.dao.IFirmwareModelMapper;
import com.autel.service.manage.model.dto.FirmwareModelDTO;
import com.autel.service.manage.model.entity.FirmwareModelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author sean
 * @version 1.3
 * @date 2022/12/21
 */
@Service
@Transactional
public class FirmwareModelServiceImpl implements IFirmwareModelService {

    @Autowired
    private IFirmwareModelMapper mapper;

    @Override
    public void saveFirmwareDeviceName(FirmwareModelDTO firmwareModel) {
        dto2Entity(firmwareModel).forEach(entity -> mapper.insert(entity));
    }

    private List<FirmwareModelEntity> dto2Entity(FirmwareModelDTO dto) {
        if (Objects.isNull(dto) || CollectionUtils.isEmpty(dto.getDeviceNames())) {
            return Collections.EMPTY_LIST;
        }
        return dto.getDeviceNames().stream()
                .map(deviceName -> FirmwareModelEntity.builder()
                        .firmwareId(dto.getFirmwareId())
                        .deviceName(deviceName).build())
                .collect(Collectors.toList());
    }
}
