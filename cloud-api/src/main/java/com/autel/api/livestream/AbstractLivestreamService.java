package com.autel.api.livestream;

import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.enums.livestream.LiveStreamMethodEnum;
import com.autel.great.mqtt.model.livestream.*;
import com.autel.great.mqtt.handle.services.ServicesPublish;
import com.autel.great.mqtt.handle.services.ServicesReplyData;
import com.autel.great.mqtt.handle.services.TopicServicesResponse;
import com.autel.great.mqtt.handle.state.TopicStateRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;


public abstract class AbstractLivestreamService {

    @Resource
    private ServicesPublish servicesPublish;

    private static final long DEFAULT_TIMEOUT = 20_000;

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_LIVESTREAM_ABILITY_UPDATE)
    public void dockLivestreamAbilityUpdate(TopicStateRequest<DockLivestreamAbilityUpdate> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockLivestreamAbilityUpdate not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_RC_LIVESTREAM_ABILITY_UPDATE)
    public void rcLivestreamAbilityUpdate(TopicStateRequest<RcLivestreamAbilityUpdate> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("rcLivestreamAbilityUpdate not implemented");
    }

    public TopicServicesResponse<ServicesReplyData<String>> liveStartPush(GatewayManager gateway, LiveStartPushRequest request) {
        return servicesPublish.publish(
                new TypeReference<String>() {
                },
                gateway.getGatewaySn(),
                LiveStreamMethodEnum.LIVE_START_PUSH.getMethod(),
                request,
                DEFAULT_TIMEOUT);
    }

    public TopicServicesResponse<ServicesReplyData<String>> liveStartPush2(GatewayManager gateway, LiveStartPushRequest2 request) {
        return servicesPublish.publish(
                new TypeReference<String>() {
                },
                gateway.getGatewaySn(),
                LiveStreamMethodEnum.LIVE_START_PUSH.getMethod(),
                request,
                DEFAULT_TIMEOUT);
    }

    public TopicServicesResponse<ServicesReplyData<String>> liveStartPush3(GatewayManager gateway, LiveStartPushRequest3 request) {
        return servicesPublish.publish(
                new TypeReference<String>() {
                },
                gateway.getGatewaySn(),
                LiveStreamMethodEnum.LIVE_START_PUSH.getMethod(),
                request,
                DEFAULT_TIMEOUT);
    }

    public TopicServicesResponse<ServicesReplyData> liveStopPush(GatewayManager gateway, LiveStopPushRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                LiveStreamMethodEnum.LIVE_STOP_PUSH.getMethod(),
                request,
                DEFAULT_TIMEOUT);
    }

    public TopicServicesResponse<ServicesReplyData> liveSetQuality(GatewayManager gateway, LiveSetQualityRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                LiveStreamMethodEnum.LIVE_SET_QUALITY.getMethod(),
                request,
                DEFAULT_TIMEOUT);
    }

    public TopicServicesResponse<ServicesReplyData> liveLensChange(GatewayManager gateway, LiveLensChangeRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                LiveStreamMethodEnum.LIVE_LENS_CHANGE.getMethod(),
                request,
                DEFAULT_TIMEOUT);
    }


}
