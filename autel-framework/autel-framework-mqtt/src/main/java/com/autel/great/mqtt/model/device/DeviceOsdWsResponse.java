package com.autel.great.mqtt.model.device;

import com.autel.great.context.base.BaseModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Schema(name = "DeviceOsdWsResponse", description = "BizCode: device_osd.<p>Websocket response data when device topology changes.</p>")
public class DeviceOsdWsResponse extends BaseModel {

    @NotNull
    @Schema(description = "drone sn", example = "1AD3CA2VL3LAD6")
    private String sn;

    @NotNull
    @Valid
    private DeviceOsdHost host;

    public DeviceOsdWsResponse() {
    }

    @Override
    public String toString() {
        return "DeviceOsdWsResponse{" +
                "sn='" + sn + '\'' +
                ", host=" + host +
                '}';
    }

    public String getSn() {
        return sn;
    }

    public DeviceOsdWsResponse setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public DeviceOsdHost getHost() {
        return host;
    }

    public DeviceOsdWsResponse setHost(DeviceOsdHost host) {
        this.host = host;
        return this;
    }
}
