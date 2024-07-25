package com.autel.great.context.web.mvc;

import com.autel.great.context.web.core.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GlobalMVCConfigurer implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    private static List<String> excludePaths = new ArrayList<>();

    @Value("${url.manage.prefix}")
    private String managePrefix;

    @Value("${url.manage.version}")
    private String manageVersion;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        excludePaths.add("/" + managePrefix + manageVersion + "/login");
        excludePaths.add("/" + managePrefix + manageVersion + "/token/refresh");
        excludePaths.add("/swagger-ui.html");
        excludePaths.add("/swagger-ui/**");
        excludePaths.add("/v3/**");
        excludePaths.add("/ui/**");
        excludePaths.add("/test/**");
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns(excludePaths);
    }
}
