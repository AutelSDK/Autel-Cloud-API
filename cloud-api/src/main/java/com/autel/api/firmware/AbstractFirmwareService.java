package com.autel.api.firmware;

import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.enums.firmware.FirmwareMethodEnum;
import com.autel.great.mqtt.handle.events.EventsDataRequest;
import com.autel.great.mqtt.handle.events.TopicEventsRequest;
import com.autel.great.mqtt.handle.events.TopicEventsResponse;
import com.autel.great.mqtt.model.firmware.OtaCreateRequest;
import com.autel.great.mqtt.model.firmware.OtaCreateResponse;
import com.autel.great.mqtt.model.firmware.OtaProgress;
import com.autel.great.mqtt.handle.services.ServicesPublish;
import com.autel.great.mqtt.handle.services.ServicesReplyData;
import com.autel.great.mqtt.handle.services.TopicServicesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;

public abstract class AbstractFirmwareService {

    @Resource
    private ServicesPublish servicesPublish;

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_OTA_PROGRESS, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> otaProgress(TopicEventsRequest<EventsDataRequest<OtaProgress>> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("otaProgress not implemented");
    }

    public TopicServicesResponse<ServicesReplyData<OtaCreateResponse>> otaCreate(GatewayManager gateway, OtaCreateRequest request) {
        return servicesPublish.publish(
                new TypeReference<OtaCreateResponse>() {
                },
                gateway.getGatewaySn(),
                FirmwareMethodEnum.OTA_CREATE.getMethod(),
                request);
    }

}
