package com.autel.great.context.web.core;

import com.autel.great.context.error.CommonErrorEnum;
import com.autel.great.context.model.CustomClaim;
import com.autel.great.context.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    public static final String PARAM_TOKEN = "x-auth-token";

    public static final String TOKEN_CLAIM = "customClaim";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //if (1 == 1) return true;

        String uri = request.getRequestURI();
        log.debug("request uri: {}, IP: {}", uri, request.getRemoteAddr());

        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            response.setStatus(HttpStatus.OK.value());
            return false;
        }
        String token = request.getHeader(PARAM_TOKEN);

        if (!StringUtils.hasText(token)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            log.error(CommonErrorEnum.NO_TOKEN.getMessage());
            return false;
        }

        Optional<CustomClaim> customClaimOpt = JwtUtil.parseToken(token);
        if (customClaimOpt.isEmpty()) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        request.setAttribute(TOKEN_CLAIM, customClaimOpt.get());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.removeAttribute(TOKEN_CLAIM);
    }
}
