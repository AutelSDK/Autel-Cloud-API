package com.autel.great.mqtt.enums.base;

import lombok.Getter;


@Getter
public enum MqttProtocolEnum {

    MQTT("tcp"),

    MQTTS("ssl"),

    WS("ws"),

    WSS("wss");

    String protocol;

    MqttProtocolEnum(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocolAddr() {
        return protocol + "://";
    }
}
