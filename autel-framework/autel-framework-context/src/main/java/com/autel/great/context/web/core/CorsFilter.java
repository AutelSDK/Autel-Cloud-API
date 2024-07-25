package com.autel.great.context.web.core;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader("Access-Control-Allow-Credentials", "true");
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        res.addHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers," +
                "Authorization, Content-Length, X-CSRF-Token, Token,session,X_Requested_With,Accept, " +
                "Origin, Host, Connection, Accept-Encoding, Accept-Language,DNT, X-CustomHeader, Keep-Alive," +
                " User-Agent, X-Requested-With, If-Modified-Since, Cache-Control, Content-Type, Pragma," + AuthInterceptor.PARAM_TOKEN);
        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
            return;
        }
        filterChain.doFilter(request, response);
    }
}