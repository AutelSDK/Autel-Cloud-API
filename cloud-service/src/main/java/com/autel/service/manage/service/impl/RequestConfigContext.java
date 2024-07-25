package com.autel.service.manage.service.impl;

import com.autel.api.config.AbstractConfigService;
import com.autel.great.context.error.CommonErrorEnum;
import com.autel.great.context.utils.SpringBeanUtilsTest;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.model.config.ProductConfigResponse;
import com.autel.great.mqtt.model.config.RequestsConfigRequest;
import com.autel.great.mqtt.handle.requests.TopicRequestsRequest;
import com.autel.great.mqtt.handle.requests.TopicRequestsResponse;
import com.autel.service.manage.model.dto.ProductConfigDTO;
import com.autel.service.manage.model.enums.CustomizeConfigScopeEnum;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequestConfigContext extends AbstractConfigService {

    @Override
    public TopicRequestsResponse<ProductConfigResponse> requestsConfig(TopicRequestsRequest<RequestsConfigRequest> request, MessageHeaders headers) {
        RequestsConfigRequest configReceiver = request.getData();
        Optional<CustomizeConfigScopeEnum> scopeEnumOpt = CustomizeConfigScopeEnum.find(configReceiver.getConfigScope().getScope());
        if (scopeEnumOpt.isEmpty()) {
            return new TopicRequestsResponse().setData(MqttReply.error(CommonErrorEnum.ILLEGAL_ARGUMENT));
        }

        ProductConfigDTO config = (ProductConfigDTO) SpringBeanUtilsTest.getBean(scopeEnumOpt.get().getClazz()).getConfig();
        return new TopicRequestsResponse<ProductConfigResponse>().setData(
                new ProductConfigResponse()
                        .setNtpServerHost(config.getNtpServerHost())
                        .setAppId(config.getAppId())
                        .setAppKey(config.getAppKey())
                        .setAppLicense(config.getAppLicense()));
    }
}
