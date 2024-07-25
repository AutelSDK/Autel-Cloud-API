package com.autel.service.manage.service.impl;

import com.autel.great.context.enums.device.DeviceDomainEnum;
import com.autel.great.mqtt.model.device.PayloadIndex;
import com.autel.great.redis.RedisConst;
import com.autel.great.redis.RedisOpsUtils;
import com.autel.service.manage.model.dto.CapacityCameraDTO;
import com.autel.service.manage.model.dto.DeviceDictionaryDTO;
import com.autel.service.manage.model.receiver.CapacityCameraReceiver;
import com.autel.service.manage.service.ICameraVideoService;
import com.autel.service.manage.service.ICapacityCameraService;
import com.autel.service.manage.service.IDeviceDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CapacityCameraServiceImpl implements ICapacityCameraService {

    @Autowired
    private ICameraVideoService cameraVideoService;

    @Autowired
    private IDeviceDictionaryService dictionaryService;

    @Override
    public List<CapacityCameraDTO> getCapacityCameraByDeviceSn(String deviceSn) {
        return (List<CapacityCameraDTO>) RedisOpsUtils.hashGet(RedisConst.LIVE_CAPACITY, deviceSn);
    }

    @Override
    public Boolean deleteCapacityCameraByDeviceSn(String deviceSn) {
        return RedisOpsUtils.hashDel(RedisConst.LIVE_CAPACITY, new String[]{deviceSn});
    }

    @Override
    public void saveCapacityCameraReceiverList(List<CapacityCameraReceiver> capacityCameraReceivers, String deviceSn) {
        List<CapacityCameraDTO> capacity = capacityCameraReceivers.stream()
                .map(this::receiver2Dto).collect(Collectors.toList());
        RedisOpsUtils.hashSet(RedisConst.LIVE_CAPACITY, deviceSn, capacity);
    }

    public CapacityCameraDTO receiver2Dto(CapacityCameraReceiver receiver) {
        CapacityCameraDTO.CapacityCameraDTOBuilder builder = CapacityCameraDTO.builder();
        if (receiver == null) {
            return builder.build();
        }
        PayloadIndex cameraIndex = receiver.getCameraIndex();
        Optional<DeviceDictionaryDTO> dictionaryOpt = dictionaryService.getOneDictionaryInfoByTypeSubType(
                DeviceDomainEnum.PAYLOAD.getDomain(), cameraIndex.getType().getType(), cameraIndex.getSubType().getSubType());
        dictionaryOpt.ifPresent(dictionary -> builder.name(dictionary.getDeviceName()));

        return builder
                .id(UUID.randomUUID().toString())
                .videosList(receiver.getVideoList()
                        .stream()
                        .map(cameraVideoService::receiver2Dto)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()))
                .index(receiver.getCameraIndex().toString())
                .build();
    }
}