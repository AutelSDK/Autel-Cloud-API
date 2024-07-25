package com.autel.api.control;

import com.autel.great.context.annotations.CloudSDKVersion;
import com.autel.great.context.base.BaseModel;
import com.autel.great.context.base.Common;
import com.autel.great.context.enums.version.CloudSDKVersionEnum;
import com.autel.great.context.enums.version.GatewayManager;
import com.autel.great.context.enums.version.GatewayTypeEnum;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.context.utils.SpringBeanUtils;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.handle.drc.DrcDownPublish;
import com.autel.great.mqtt.handle.drc.DrcUpData;
import com.autel.great.mqtt.handle.drc.TopicDrcRequest;
import com.autel.great.mqtt.enums.control.ControlMethodEnum;
import com.autel.great.mqtt.enums.control.PayloadControlMethodEnum;
import com.autel.great.mqtt.handle.events.EventsDataRequest;
import com.autel.great.mqtt.handle.events.TopicEventsRequest;
import com.autel.great.mqtt.handle.events.TopicEventsResponse;
import com.autel.great.mqtt.model.control.*;
import com.autel.great.mqtt.handle.services.ServicesPublish;
import com.autel.great.mqtt.handle.services.ServicesReplyData;
import com.autel.great.mqtt.handle.services.TopicServicesResponse;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public abstract class AbstractControlService {

    @Resource
    private ServicesPublish servicesPublish;

    @Resource
    private DrcDownPublish drcDownPublish;

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_FLY_TO_POINT_PROGRESS, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> flyToPointProgress(TopicEventsRequest<FlyToPointProgress> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("flyToPointProgress not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_TAKEOFF_TO_POINT_PROGRESS, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> takeoffToPointProgress(TopicEventsRequest<TakeoffToPointProgress> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("takeoffToPointProgress not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_DRC_STATUS_NOTIFY, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> drcStatusNotify(TopicEventsRequest<DrcStatusNotify> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("drcStatusNotify not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_JOYSTICK_INVALID_NOTIFY, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> joystickInvalidNotify(TopicEventsRequest<JoystickInvalidNotify> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("joystickInvalidNotify not implemented");
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> flightAuthorityGrab(GatewayManager gateway) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.FLIGHT_AUTHORITY_GRAB.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> payloadAuthorityGrab(GatewayManager gateway, PayloadAuthorityGrabRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.PAYLOAD_AUTHORITY_GRAB.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> drcModeEnter(GatewayManager gateway, DrcModeEnterRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.DRC_MODE_ENTER.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> drcModeExit(GatewayManager gateway) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.DRC_MODE_EXIT.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> takeoffToPoint(GatewayManager gateway, TakeoffToPointRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.TAKEOFF_TO_POINT.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> flyToPoint(GatewayManager gateway, FlyToPointRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.FLY_TO_POINT.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, exclude = GatewayTypeEnum.RC, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> flyToPointUpdate(GatewayManager gateway, FlyToPointUpdateRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.FLY_TO_POINT_UPDATE.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> flyToPointStop(GatewayManager gateway) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.FLY_TO_POINT_STOP.getMethod());
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> cameraModeSwitch(GatewayManager gateway, CameraModeSwitchRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_MODE_SWITCH.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> cameraPhotoTake(GatewayManager gateway, CameraPhotoTakeRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_PHOTO_TAKE.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, exclude = GatewayTypeEnum.RC, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> cameraPhotoStop(GatewayManager gateway, CameraPhotoStopRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_PHOTO_STOP.getMethod(),
                request);
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_CAMERA_PHOTO_TAKE_PROGRESS, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> cameraPhotoTakeProgress(TopicEventsRequest<EventsDataRequest<CameraPhotoTakeProgress>> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("cameraPhotoTakeProgress not implemented");
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> cameraRecordingStart(GatewayManager gateway, CameraRecordingStartRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_RECORDING_START.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> cameraRecordingStop(GatewayManager gateway, CameraRecordingStopRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_RECORDING_STOP.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> cameraAim(GatewayManager gateway, CameraAimRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_AIM.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> cameraFocalLengthSet(GatewayManager gateway, CameraFocalLengthSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_FOCAL_LENGTH_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> gimbalReset(GatewayManager gateway, GimbalResetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.GIMBAL_RESET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0, exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> cameraLookAt(GatewayManager gateway, CameraLookAtRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_LOOK_AT.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0, exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> cameraScreenSplit(GatewayManager gateway, CameraScreenSplitRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_SCREEN_SPLIT.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0, exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> photoStorageSet(GatewayManager gateway, PhotoStorageSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.PHOTO_STORAGE_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0, exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> videoStorageSet(GatewayManager gateway, VideoStorageSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.VIDEO_STORAGE_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> cameraExposureSet(GatewayManager gateway, CameraExposureSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_EXPOSURE_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> cameraExposureModeSet(GatewayManager gateway, CameraExposureModeSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_EXPOSURE_MODE_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> cameraFocusModeSet(GatewayManager gateway, CameraFocusModeSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_FOCUS_MODE_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> cameraFocusValueSet(GatewayManager gateway, CameraFocusValueSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_FOCUS_VALUE_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> irMeteringModeSet(GatewayManager gateway, IrMeteringModeSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.IR_METERING_MODE_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> irMeteringPointSet(GatewayManager gateway, IrMeteringPointSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.IR_METERING_POINT_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> irMeteringAreaSet(GatewayManager gateway, IrMeteringAreaSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.IR_METERING_AREA_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> cameraPointFocusAction(GatewayManager gateway, CameraPointFocusActionRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.CAMERA_POINT_FOCUS_ACTION.getMethod(),
                request);
    }

    public TopicServicesResponse<ServicesReplyData> payloadControl(GatewayManager gateway, PayloadControlMethodEnum methodEnum, BaseModel request) {
        try {
            AbstractControlService abstractControlService = SpringBeanUtils.getBean(this.getClass());
            Method method = abstractControlService.getClass().getDeclaredMethod(
                    Common.convertSnake(methodEnum.getPayloadMethod().getMethod()), GatewayManager.class, methodEnum.getClazz());
            return (TopicServicesResponse<ServicesReplyData>) method.invoke(abstractControlService, gateway, request);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new CloudSDKException(e);
        } catch (InvocationTargetException e) {
            throw new CloudSDKException(e.getTargetException());
        }
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_POI_STATUS_NOTIFY, outputChannel = ChannelName.OUTBOUND_EVENTS)
    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    public TopicEventsResponse<MqttReply> poiStatusNotify(TopicEventsRequest<PoiStatusNotify> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("poiStatusNotify not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, exclude = GatewayTypeEnum.RC, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> poiModeEnter(GatewayManager gateway, PoiModeEnterRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.POI_MODE_ENTER.getMethod(),
                request);
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, exclude = GatewayTypeEnum.RC, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> poiModeExit(GatewayManager gateway) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.POI_MODE_EXIT.getMethod());
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, exclude = GatewayTypeEnum.RC, include = GatewayTypeEnum.DOCK)
    public TopicServicesResponse<ServicesReplyData> poiCircleSpeedSet(GatewayManager gateway, PoiCircleSpeedSetRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.POI_CIRCLE_SPEED_SET.getMethod(),
                request);
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    protected void droneControlDown(GatewayManager gateway, DroneControlRequest request) {
        drcDownPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.DRONE_CONTROL.getMethod(),
                request);
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_DRC_UP_DRONE_CONTROL)
    public void droneControlUp(TopicDrcRequest<DrcUpData<DroneControlResponse>> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("droneControlUp not implemented");
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public void droneEmergencyStopDown(GatewayManager gateway) {
        drcDownPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.DRONE_EMERGENCY_STOP.getMethod());
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_DRC_UP_DRONE_EMERGENCY_STOP)
    public void droneEmergencyStopUp(TopicDrcRequest<DrcUpData> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("droneEmergencyStopUp not implemented");
    }

    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public void heartBeatDown(GatewayManager gateway, HeartBeatRequest request) {
        drcDownPublish.publish(
                gateway.getGatewaySn(),
                ControlMethodEnum.HEART_BEAT.getMethod(),
                request);
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_DRC_UP_HEART_BEAT)
    public void heartBeatUp(TopicDrcRequest<HeartBeatRequest> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("heartBeatUp not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_DRC_UP_HSI_INFO_PUSH)
    public void hsiInfoPush(TopicDrcRequest<HsiInfoPush> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("hsiInfoPush not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_DRC_UP_DELAY_INFO_PUSH)
    public void delayInfoPush(TopicDrcRequest<DelayInfoPush> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("delayInfoPush not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_DRC_UP_OSD_INFO_PUSH)
    public void osdInfoPush(TopicDrcRequest<OsdInfoPush> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("osdInfoPush not implemented");
    }


}
