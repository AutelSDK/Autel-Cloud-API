package com.autel.service.manage.model.dto;

import com.autel.great.mqtt.enums.control.ControlSourceEnum;
import com.autel.service.control.model.enums.DroneAuthorityEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceAuthorityDTO {

    private String sn;

    private DroneAuthorityEnum type;

    private ControlSourceEnum controlSource;

}
