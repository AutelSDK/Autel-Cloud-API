package com.autel.service.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.autel.api.livestream.AbstractLivestreamService;
import com.autel.great.context.response.HttpResultResponse;
import com.autel.great.mqtt.core.produce.IMqttMessageGateway;
import com.autel.great.mqtt.enums.livestream.LiveStreamMethodEnum;
import com.autel.great.mqtt.model.livestream.LiveStartPushRequest3;
import com.autel.great.mqtt.model.storage.StsCredentialsResponse;
import com.autel.great.mqtt.handle.services.ServicesPublish;
import com.autel.great.mqtt.handle.services.ServicesReplyData;
import com.autel.great.mqtt.handle.services.TopicServicesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class TestController {
    @Autowired
    private IMqttMessageGateway iMqttMessageGateway;
    @Autowired
    private AbstractLivestreamService abstractLivestreamService;
    @Resource
    private ServicesPublish servicesPublish;


    @Operation(summary = "测试方法")
    @PostMapping("/test/test1")
    HttpResultResponse<StsCredentialsResponse> test1() {
        iMqttMessageGateway.publish("thing/product/SN1000001/state", new String("你好").getBytes());


        return HttpResultResponse.success();
    }

    /**
     * {
     * "videoType": "zoom",
     * "url_type": "1",
     * "video_id": "1748FEV3HMA923091031/89-0-7/normal-0",
     * "video_quality": "0"
     * }
     *
     * @return
     */
    private static final long DEFAULT_TIMEOUT = 20_000;

    @Operation(summary = "测试方法2")
    @PostMapping("/test/test2")
    HttpResultResponse<StsCredentialsResponse> test2() {
        LiveStartPushRequest3 request = new LiveStartPushRequest3();
        request.setUrl("rtmp://test-mediacenter.autelrobotics.cn:1936/live/1748FEV3HMA923091031/nest-camera-out/normal");
        request.setVideo_id("1748FEV3HMA923091031/nest-camera-out/normal");
        request.setUrl_type(1);
        request.setVideo_quality(0);
        TopicServicesResponse<ServicesReplyData<String>> ret = servicesPublish.publish(
                new TypeReference<String>() {
                },
                "TH7923350704",
                LiveStreamMethodEnum.LIVE_START_PUSH.getMethod(),
                request
                ,
                DEFAULT_TIMEOUT);
        log.info("打印:{}", JSONUtils.toJSONString(ret));
        return HttpResultResponse.success();
    }

}
