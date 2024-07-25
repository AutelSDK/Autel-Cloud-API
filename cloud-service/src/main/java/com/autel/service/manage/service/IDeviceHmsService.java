package com.autel.service.manage.service;

import com.autel.great.context.page.PaginationData;
import com.autel.service.manage.model.dto.DeviceHmsDTO;
import com.autel.service.manage.model.param.DeviceHmsQueryParam;

public interface IDeviceHmsService {

    PaginationData<DeviceHmsDTO> getDeviceHmsByParam(DeviceHmsQueryParam param);
    void updateUnreadHms(String deviceSn);
}
