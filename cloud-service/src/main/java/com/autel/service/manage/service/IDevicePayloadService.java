package com.autel.service.manage.service;

import com.autel.great.mqtt.model.device.PayloadFirmwareVersion;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.model.dto.DevicePayloadDTO;
import com.autel.service.manage.model.dto.DevicePayloadReceiver;

import java.util.Collection;
import java.util.List;

public interface IDevicePayloadService {

    Integer checkPayloadExist(String payloadSn);
    Boolean savePayloadDTOs(DeviceDTO drone, List<DevicePayloadReceiver> payloadReceiverList);

    Integer saveOnePayloadDTO(DevicePayloadReceiver payloadReceiver);
    List<DevicePayloadDTO> getDevicePayloadEntitiesByDeviceSn(String deviceSn);

    void deletePayloadsByDeviceSn(List<String> deviceSns);
    Boolean updateFirmwareVersion(String droneSn, PayloadFirmwareVersion receiver);

    void deletePayloadsByPayloadsSn(Collection<String> payloadSns);

    Boolean checkAuthorityPayload(String deviceSn, String payloadIndex);

    void updatePayloadControl(DeviceDTO drone, List<DevicePayloadReceiver> payloads);
}