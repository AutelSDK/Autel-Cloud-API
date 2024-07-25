package com.autel.great.oss.service.impl;

import com.autel.great.oss.model.OssConfiguration;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class OssAspectHandler {

    @Autowired
    private OssServiceContext ossServiceContext;

    @Before("execution(public * com.autel.great.oss.service.impl.OssServiceContext.*(..))")
    public void before() {
        if (!OssConfiguration.enable) {
            throw new IllegalArgumentException("Please enable OssConfiguration.");
        }
        if (this.ossServiceContext.getOssService() == null) {
            throw new IllegalArgumentException("Please check the OssConfiguration configuration.");
        }
        this.ossServiceContext.createClient();
    }
}
