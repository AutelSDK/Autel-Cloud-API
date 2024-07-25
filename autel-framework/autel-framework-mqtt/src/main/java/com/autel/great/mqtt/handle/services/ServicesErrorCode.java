package com.autel.great.mqtt.handle.services;


import com.autel.great.context.error.ErrorCodeSourceEnum;
import com.autel.great.context.error.IErrorInfo;
import com.autel.great.mqtt.core.consume.MqttReply;

import com.autel.great.mqtt.enums.base.CommonErrorEnum;
import com.autel.great.mqtt.enums.control.ControlErrorCodeEnum;
import com.autel.great.mqtt.enums.debug.DebugErrorCodeEnum;
import com.autel.great.mqtt.enums.firmware.FirmwareErrorCodeEnum;
import com.autel.great.mqtt.enums.livestream.LiveErrorCodeEnum;
import com.autel.great.mqtt.enums.log.LogErrorCodeEnum;
import com.autel.great.mqtt.enums.wayline.WaylineErrorCodeEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServicesErrorCode implements IErrorInfo {

    private static final int MOD = 100_000;

    private ErrorCodeSourceEnum source;

    private IServicesErrorCode errorCode;

    private boolean success;

    private Integer sourceCode;

    @Override
    public String toString() {
        return "{" +
                "errorCode=" + getCode() +
                ", errorMsg=" + getMessage() +
                '}';
    }

    @JsonCreator
    public ServicesErrorCode(int code) {
        this.sourceCode = code;
        if (MqttReply.CODE_SUCCESS == code) {
            this.success = true;
            this.errorCode = CommonErrorEnum.SUCCESS;
            return;
        }
        if (1 == code) {
            log.info("失败");
            return;
        }
        this.source = ErrorCodeSourceEnum.find(code / MOD);
        this.errorCode = LiveErrorCodeEnum.find(code % MOD);
        if (errorCode.getCode() != -1) {
            return;
        }
        this.errorCode = DebugErrorCodeEnum.find(code);
        if (errorCode.getCode() != -1) {
            return;
        }
        this.errorCode = ControlErrorCodeEnum.find(code);
        if (errorCode.getCode() != -1) {
            return;
        }
        this.errorCode = LogErrorCodeEnum.find(code);
        if (errorCode.getCode() != -1) {
            return;
        }
        this.errorCode = FirmwareErrorCodeEnum.find(code);
        if (errorCode.getCode() != -1) {
            return;
        }
        this.errorCode = WaylineErrorCodeEnum.find(code);
        if (errorCode.getCode() != -1) {
            return;
        }
        this.errorCode = CommonErrorEnum.find(code);
    }

    @Override
    public String getMessage() {
        return errorCode.getMessage();
    }

    @JsonValue
    public Integer getCode() {
        return sourceCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public ErrorCodeSourceEnum getSource() {
        return source;
    }
}
