package com.autel.service.control.model.param;

import com.autel.great.mqtt.enums.control.CameraTypeEnum;
import com.autel.great.mqtt.enums.device.CameraModeEnum;
import com.autel.service.control.model.enums.GimbalResetModeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class DronePayloadParam {

    @Pattern(regexp = "\\d+-\\d+-\\d+")
    @NotNull
    private String payloadIndex;

    private CameraTypeEnum cameraType;

    @Range(min = 2, max = 200)
    private Float zoomFactor;

    private CameraModeEnum cameraMode;

    private Boolean locked;

    private Double pitchSpeed;

    private Double yawSpeed;

    @Range(min = 0, max = 1)
    private Double x;

    @Range(min = 0, max = 1)
    private Double y;

    private GimbalResetModeEnum resetMode;
}
