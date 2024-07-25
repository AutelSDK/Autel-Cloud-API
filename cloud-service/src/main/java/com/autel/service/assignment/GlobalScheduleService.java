package com.autel.service.assignment;

import com.autel.great.redis.RedisConst;
import com.autel.great.redis.RedisOpsUtils;
import com.autel.great.mqtt.core.subscribe.IMqttTopicService;
import com.autel.great.context.enums.device.DeviceDomainEnum;
import com.autel.service.manage.model.dto.DeviceDTO;
import com.autel.service.manage.service.IDeviceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class GlobalScheduleService {

    @Autowired
    private IDeviceService deviceService;

    @Autowired
    private IMqttTopicService topicService;

    @Autowired
    private ObjectMapper mapper;

    @Scheduled(initialDelay = 10, fixedRate = 30, timeUnit = TimeUnit.SECONDS)
    private void deviceStatusListen() {
        int start = RedisConst.DEVICE_ONLINE_PREFIX.length();

        RedisOpsUtils.getAllKeys(RedisConst.DEVICE_ONLINE_PREFIX + "*").forEach(key -> {
            long expire = RedisOpsUtils.getExpire(key);
            if (expire <= 30) {
                DeviceDTO device = (DeviceDTO) RedisOpsUtils.get(key);
                if (null == device) {
                    return;
                }
                if (DeviceDomainEnum.DRONE == device.getDomain()) {
                    deviceService.subDeviceOffline(key.substring(start));
                } else {
                    deviceService.gatewayOffline(key.substring(start));
                }
                RedisOpsUtils.del(key);
            }
        });

        log.info("Subscriptions: {}", Arrays.toString(topicService.getSubscribedTopic()));
    }

}