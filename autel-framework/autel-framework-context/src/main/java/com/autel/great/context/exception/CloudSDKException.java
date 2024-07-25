package com.autel.great.context.exception;


import com.autel.great.context.error.IErrorInfo;

import java.util.Arrays;


public class CloudSDKException extends RuntimeException {

    private IErrorInfo errorInfo;

    public CloudSDKException(String message) {
        super(message);
        this.errorInfo = CloudSDKErrorEnum.UNKNOWN;
    }

    public CloudSDKException(Throwable cause) {
        super(cause);
        this.errorInfo = CloudSDKErrorEnum.UNKNOWN;
    }

    public CloudSDKException() {
        this("SDK Exception");
        this.errorInfo = CloudSDKErrorEnum.UNKNOWN;
    }

    public CloudSDKException(Class clazz, Object... code) {
        this(clazz.getName() + " has unknown data: " + Arrays.toString(code));
        this.errorInfo = CloudSDKErrorEnum.WRONG_DATA;
    }

    public CloudSDKException(IErrorInfo err) {
        this(err, null);
    }

    public CloudSDKException(IErrorInfo err, String msg) {
        this(String.format("Error Code: %d, Error Msg: %s. %s", err.getCode(), err.getMessage(), msg));
        this.errorInfo = err;
    }

    public IErrorInfo getErrorInfo() {
        return errorInfo;
    }
}
