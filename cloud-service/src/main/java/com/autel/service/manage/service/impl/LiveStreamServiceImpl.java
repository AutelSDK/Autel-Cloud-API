package com.autel.service.manage.service.impl;

import com.autel.api.livestream.AbstractLivestreamService;
import com.autel.great.context.enums.device.DeviceDomainEnum;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.enums.livestream.LiveErrorCodeEnum;
import com.autel.great.mqtt.enums.livestream.UrlTypeEnum;
import com.autel.great.mqtt.model.device.VideoId;
import com.autel.great.mqtt.model.livestream.*;
import com.autel.great.mqtt.core.SDKManager;
import com.autel.great.mqtt.handle.services.ServicesReplyData;
import com.autel.great.mqtt.handle.services.TopicServicesResponse;
import com.autel.service.manage.model.dto.*;
import com.autel.service.manage.model.param.DeviceQueryParam;
import com.autel.service.manage.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class LiveStreamServiceImpl implements ILiveStreamService {

    @Autowired
    private ICapacityCameraService capacityCameraService;

    @Autowired
    private IDeviceService deviceService;

    @Autowired
    private IWorkspaceService workspaceService;

    @Autowired
    private IDeviceRedisService deviceRedisService;

    @Autowired
    private AbstractLivestreamService abstractLivestreamService;

    @Override
    public List<CapacityDeviceDTO> getLiveCapacity(String workspaceId) {
        List<DeviceDTO> devicesList = deviceService.getDevicesByParams(
                DeviceQueryParam.builder()
                        .workspaceId(workspaceId)
                        .domains(List.of(DeviceDomainEnum.DRONE.getDomain(), DeviceDomainEnum.DOCK.getDomain()))
                        .build());

        return devicesList.stream()
                .filter(device -> deviceRedisService.checkDeviceOnline(device.getDeviceSn()))
                .map(device -> CapacityDeviceDTO.builder()
                        .name(Objects.requireNonNullElse(device.getNickname(), device.getDeviceName()))
                        .sn(device.getDeviceSn())
                        .camerasList(capacityCameraService.getCapacityCameraByDeviceSn(device.getDeviceSn()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public HttpResultResponse liveStart(LiveTypeDTO liveParam) {
        HttpResultResponse<DeviceDTO> responseResult = this.checkBeforeLive(liveParam.getVideoId());
        if (HttpResultResponse.CODE_SUCCESS != responseResult.getCode()) {
            return responseResult;
        }

        ILivestreamUrl url = LiveStreamProperty.get(liveParam.getUrlType());

        url = setExt(liveParam.getUrlType(), url, liveParam.getVideoId());

        LiveStartPushRequest3 request3 = new LiveStartPushRequest3();
        request3.setUrl(url.toString());
        request3.setUrl_type(liveParam.getUrlType().getType());
        request3.setVideo_id(liveParam.getVideoId().getDroneSn() + "-" + liveParam.getVideoId().getPayloadIndex().toString());


        request3.setVideo_quality(liveParam.getVideoQuality().getQuality());

        TopicServicesResponse<ServicesReplyData<String>> response = abstractLivestreamService.liveStartPush3(
                SDKManager.getDeviceSDK(responseResult.getData().getDeviceSn()),
                request3);

        log.info("发送媒体响应:{}", response);
        if (!response.getData().getResult().isSuccess()) {
            return HttpResultResponse.error(response.getData().getResult());
        }

        LiveDTO live = new LiveDTO();

        switch (liveParam.getUrlType()) {
            case AGORA:
                break;
            case RTMP:
                /**
                 * live.setUrl(url.toString().replace("rtmp", "webrtc"));
                 */
                LivestreamRtmpUrl rtmpUrl = (LivestreamRtmpUrl) url;
                live.setUrl(rtmpUrl.getPayUrl());
                break;
            case GB28181:
                LivestreamGb28181Url gb28181 = (LivestreamGb28181Url) url;
                live.setUrl(new StringBuilder()
                        .append("webrtc://")
                        .append(gb28181.getServerIP())
                        .append("/live/")
                        .append(gb28181.getAgentID())
                        .append("@")
                        .append(gb28181.getChannel())
                        .toString());
                break;
            case RTSP:
                //live.setUrl(response.getData().getOutput());
                break;
            case WHIP:
                live.setUrl(url.toString().replace("whip", "whep"));
                break;
            default:
                return HttpResultResponse.error(LiveErrorCodeEnum.URL_TYPE_NOT_SUPPORTED);
        }

        return HttpResultResponse.success(live);
    }

    @Override
    public HttpResultResponse liveStop(VideoId videoId) {
        HttpResultResponse<DeviceDTO> responseResult = this.checkBeforeLive(videoId);
        if (HttpResultResponse.CODE_SUCCESS != responseResult.getCode()) {
            return responseResult;
        }

        TopicServicesResponse<ServicesReplyData> response = abstractLivestreamService.liveStopPush(
                SDKManager.getDeviceSDK(responseResult.getData().getDeviceSn()), new LiveStopPushRequest()
                        .setVideoId(videoId));
        if (!response.getData().getResult().isSuccess()) {
            return HttpResultResponse.error(response.getData().getResult());
        }

        return HttpResultResponse.success();
    }

    @Override
    public HttpResultResponse liveSetQuality(LiveTypeDTO liveParam) {
        HttpResultResponse<DeviceDTO> responseResult = this.checkBeforeLive(liveParam.getVideoId());
        if (responseResult.getCode() != 0) {
            return responseResult;
        }

        TopicServicesResponse<ServicesReplyData> response = abstractLivestreamService.liveSetQuality(
                SDKManager.getDeviceSDK(responseResult.getData().getDeviceSn()), new LiveSetQualityRequest()
                        .setVideoQuality(liveParam.getVideoQuality())
                        .setVideoId(liveParam.getVideoId()));
        if (!response.getData().getResult().isSuccess()) {
            return HttpResultResponse.error(response.getData().getResult());
        }

        return HttpResultResponse.success();
    }

    @Override
    public HttpResultResponse liveLensChange(LiveTypeDTO liveParam) {
        HttpResultResponse<DeviceDTO> responseResult = this.checkBeforeLive(liveParam.getVideoId());
        if (HttpResultResponse.CODE_SUCCESS != responseResult.getCode()) {
            return responseResult;
        }

        TopicServicesResponse<ServicesReplyData> response = abstractLivestreamService.liveLensChange(
                SDKManager.getDeviceSDK(responseResult.getData().getDeviceSn()), new LiveLensChangeRequest()
                        .setVideoType(liveParam.getVideoType())
                        .setVideoId(liveParam.getVideoId()));

        if (!response.getData().getResult().isSuccess()) {
            return HttpResultResponse.error(response.getData().getResult());
        }

        return HttpResultResponse.success();
    }

    private HttpResultResponse<DeviceDTO> checkBeforeLive(VideoId videoId) {
        if (Objects.isNull(videoId)) {
            return HttpResultResponse.error(LiveErrorCodeEnum.ERROR_PARAMETERS);
        }

        Optional<DeviceDTO> deviceOpt = deviceService.getDeviceBySn(videoId.getDroneSn());
        if (deviceOpt.isEmpty()) {
            return HttpResultResponse.error(LiveErrorCodeEnum.NO_AIRCRAFT);
        }

        if (DeviceDomainEnum.DOCK == deviceOpt.get().getDomain()) {
            return HttpResultResponse.success(deviceOpt.get());
        }
        List<DeviceDTO> gatewayList = deviceService.getDevicesByParams(
                DeviceQueryParam.builder()
                        .childSn(videoId.getDroneSn())
                        .build());
        if (gatewayList.isEmpty()) {
            return HttpResultResponse.error(LiveErrorCodeEnum.NO_FLIGHT_CONTROL);
        }

        return HttpResultResponse.success(gatewayList.get(0));
    }

    /**
     * This is business-customized logic and is only used for testing.
     *
     * @param type
     * @param url
     * @param videoId
     */
    private ILivestreamUrl setExt(UrlTypeEnum type, ILivestreamUrl url, VideoId videoId) {
        switch (type) {
            case AGORA:
                LivestreamAgoraUrl agoraUrl = (LivestreamAgoraUrl) url.clone();
                return agoraUrl.setSn(videoId.getDroneSn());
            case RTMP:
                LivestreamRtmpUrl rtmpUrl = (LivestreamRtmpUrl) url.clone();
                /**
                 * Set playback address and set streaming address
                 */
                return rtmpUrl.setPayUrl(String.format(rtmpUrl.getPayUrl(), videoId.getDroneSn() + "-" + videoId.getPayloadIndex().toString())).setUrl(rtmpUrl.getUrl() + videoId.getDroneSn() + "-" + videoId.getPayloadIndex().toString());
            case GB28181:
                String random = String.valueOf(Math.abs(videoId.getDroneSn().hashCode()) % 1000);
                LivestreamGb28181Url gbUrl = (LivestreamGb28181Url) url.clone();
                gbUrl.setAgentID(gbUrl.getAgentID().substring(0, 20 - random.length()) + random);
                String deviceType = String.valueOf(videoId.getPayloadIndex().getType().getType());
                return gbUrl.setChannel(gbUrl.getChannel().substring(0, 20 - deviceType.length()) + deviceType);
            case WHIP:
                LivestreamWhipUrl whipUrl = (LivestreamWhipUrl) url.clone();
                return whipUrl.setUrl(whipUrl.getUrl() + videoId.getDroneSn() + "-" + videoId.getPayloadIndex().toString());
        }
        return url;
    }
}