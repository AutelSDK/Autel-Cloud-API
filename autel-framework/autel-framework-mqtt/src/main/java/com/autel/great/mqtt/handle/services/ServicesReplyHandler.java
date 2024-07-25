package com.autel.great.mqtt.handle.services;

import com.autel.great.context.base.Common;
import com.autel.great.mqtt.core.sync.Chan;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.enums.log.LogMethodEnum;
import com.autel.great.mqtt.model.log.FileUploadListResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
public class ServicesReplyHandler {

    @ServiceActivator(inputChannel = ChannelName.INBOUND_SERVICES_REPLY)
    public void servicesReply(Message<?> message) throws IOException {
        byte[] payload = (byte[]) message.getPayload();

        TopicServicesResponse<ServicesReplyReceiver> receiver = Common.getObjectMapper()
                .readValue(payload, new TypeReference<TopicServicesResponse<ServicesReplyReceiver>>() {
                });
        Chan chan = Chan.getInstance(receiver.getTid(), false);
        if (Objects.isNull(chan)) {
            return;
        }
        log.info("【services_reply】设备回复:{}", receiver.getData());
        if (LogMethodEnum.FILE_UPLOAD_LIST.getMethod().equals(receiver.getMethod())) {
            receiver.getData().setOutput(Common.getObjectMapper().convertValue(receiver.getData(),
                    new TypeReference<FileUploadListResponse>() {
                    }));
        }
        chan.put(receiver);
    }
}
