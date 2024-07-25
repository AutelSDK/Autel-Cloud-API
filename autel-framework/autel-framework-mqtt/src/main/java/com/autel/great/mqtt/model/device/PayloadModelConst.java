package com.autel.great.mqtt.model.device;

import com.autel.great.context.enums.device.DeviceDomainEnum;
import com.autel.great.context.enums.device.DeviceEnum;
import com.autel.great.mqtt.enums.device.PayloadPositionEnum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PayloadModelConst {

    private PayloadModelConst() {
    }

    public static final String PAYLOAD_KEY = "payload";

    public static Set<String> getAllModelWithPosition() {
        Set<String> position = Arrays.stream(PayloadPositionEnum.values()).map(PayloadPositionEnum::getPosition)
                .map(String::valueOf).collect(Collectors.toSet());
        return Arrays.stream(DeviceEnum.values()).filter(device -> DeviceDomainEnum.PAYLOAD == device.getDomain())
                .map(Enum::name).map(name -> name.replace("_CAMERA", ""))
                .flatMap(m -> position.stream().map(p -> m.concat("-").concat(p))).collect(Collectors.toSet());
    }

    public static Set<String> getAllIndexWithPosition() {
        Set<String> position = Arrays.stream(PayloadPositionEnum.values()).map(PayloadPositionEnum::getPosition)
                .map(String::valueOf).collect(Collectors.toSet());
        return Arrays.stream(DeviceEnum.values()).filter(device -> DeviceDomainEnum.PAYLOAD == device.getDomain())
                .map(device -> String.format("%d-%d", device.getType().getType(), device.getSubType().getSubType()))
                .flatMap(m -> position.stream().map(p -> m.concat("-").concat(p))).collect(Collectors.toSet());
    }

}
