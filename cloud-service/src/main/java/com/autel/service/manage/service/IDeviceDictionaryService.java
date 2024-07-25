package com.autel.service.manage.service;

import com.autel.service.manage.model.dto.DeviceDictionaryDTO;

import java.util.Optional;

public interface IDeviceDictionaryService {

    Optional<DeviceDictionaryDTO> getOneDictionaryInfoByTypeSubType(Integer domain, Integer deviceType, Integer subType);

}
