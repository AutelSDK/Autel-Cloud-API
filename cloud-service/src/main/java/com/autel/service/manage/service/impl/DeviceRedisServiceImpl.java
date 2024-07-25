package com.autel.service.manage.service.impl;

import com.autel.great.mqtt.core.EventsReceiver;
import com.autel.great.mqtt.model.firmware.OtaProgress;
import com.autel.great.redis.RedisConst;
import com.autel.great.redis.RedisOpsUtils;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.service.ICapacityCameraService;
import com.autel.service.manage.service.IDeviceRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeviceRedisServiceImpl implements IDeviceRedisService {

    @Autowired
    private ICapacityCameraService capacityCameraService;

    @Override
    public Boolean checkDeviceOnline(String sn) {
        String key = RedisConst.DEVICE_ONLINE_PREFIX + sn;
        return RedisOpsUtils.checkExist(key) && RedisOpsUtils.getExpire(key) > 0;
    }

    @Override
    public Optional<DeviceDTO> getDeviceOnline(String sn) {
        return Optional.ofNullable((DeviceDTO) RedisOpsUtils.get(RedisConst.DEVICE_ONLINE_PREFIX + sn));
    }

    @Override
    public void setDeviceOnline(DeviceDTO device) {
        RedisOpsUtils.setWithExpire(RedisConst.DEVICE_ONLINE_PREFIX + device.getDeviceSn(), device, RedisConst.DEVICE_ALIVE_SECOND);
    }

    @Override
    public Boolean delDeviceOnline(String sn) {
        return RedisOpsUtils.del(RedisConst.DEVICE_ONLINE_PREFIX + sn);
    }

    @Override
    public void setDeviceOsd(String sn, Object data) {
        RedisOpsUtils.setWithExpire(RedisConst.OSD_PREFIX + sn, data, RedisConst.DEVICE_ALIVE_SECOND);
    }

    @Override
    public <T> Optional<T> getDeviceOsd(String sn, Class<T> clazz) {
        return Optional.ofNullable(clazz.cast(RedisOpsUtils.get(RedisConst.OSD_PREFIX + sn)));
    }

    @Override
    public Boolean delDeviceOsd(String sn) {
        return RedisOpsUtils.del(RedisConst.OSD_PREFIX + sn);
    }

    @Override
    public void setFirmwareUpgrading(String sn, EventsReceiver<OtaProgress> events) {
        RedisOpsUtils.setWithExpire(RedisConst.FIRMWARE_UPGRADING_PREFIX + sn, events, RedisConst.DEVICE_ALIVE_SECOND * 20);
    }

    @Override
    public Optional<EventsReceiver<OtaProgress>> getFirmwareUpgradingProgress(String sn) {
        return Optional.ofNullable((EventsReceiver<OtaProgress>) RedisOpsUtils.get(RedisConst.FIRMWARE_UPGRADING_PREFIX + sn));
    }

    @Override
    public Boolean delFirmwareUpgrading(String sn) {
        return RedisOpsUtils.del(RedisConst.FIRMWARE_UPGRADING_PREFIX + sn);
    }

    @Override
    public void addEndHmsKeys(String sn, String... keys) {
        RedisOpsUtils.listRPush(RedisConst.HMS_PREFIX + sn, keys);
    }

    @Override
    public Set<String> getAllHmsKeys(String sn) {
        return RedisOpsUtils.listGetAll(RedisConst.HMS_PREFIX + sn).stream()
                .map(String::valueOf).collect(Collectors.toSet());
    }

    @Override
    public Boolean delHmsKeysBySn(String sn) {
        return RedisOpsUtils.del(RedisConst.HMS_PREFIX + sn);
    }

    @Override
    public void gatewayOffline(String gatewaySn) {
        delDeviceOnline(gatewaySn);
        delHmsKeysBySn(gatewaySn);
        capacityCameraService.deleteCapacityCameraByDeviceSn(gatewaySn);
    }

    @Override
    public void subDeviceOffline(String deviceSn) {
        delDeviceOnline(deviceSn);
        delDeviceOsd(deviceSn);
        delHmsKeysBySn(deviceSn);
        capacityCameraService.deleteCapacityCameraByDeviceSn(deviceSn);
    }
}
