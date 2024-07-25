package com.autel.service.manage.model.receiver;

import com.autel.great.mqtt.enums.livestream.VideoTypeEnum;
import lombok.Data;

import java.util.List;

@Data
public class CapacityVideoReceiver {

    private String videoIndex;

    private VideoTypeEnum videoType;

    private List<VideoTypeEnum> switchableVideoTypes;
}