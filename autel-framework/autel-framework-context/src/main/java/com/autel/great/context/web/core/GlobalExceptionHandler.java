package com.autel.great.context.web.core;

import com.autel.great.context.response.HttpResultResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public HttpResultResponse exceptionHandler(Exception e) {
        e.printStackTrace();
        return HttpResultResponse.error(e.getLocalizedMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public HttpResultResponse nullPointerExceptionHandler(NullPointerException e) {
        e.printStackTrace();
        return HttpResultResponse.error("A null object appeared.");
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public HttpResultResponse methodArgumentNotValidExceptionHandler(BindException e) {
        e.printStackTrace();
        return HttpResultResponse.error(e.getFieldError().getField() + e.getFieldError().getDefaultMessage());
    }

}
