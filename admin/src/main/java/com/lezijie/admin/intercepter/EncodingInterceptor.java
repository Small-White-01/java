package com.lezijie.admin.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String serverInfo = request.getServletContext().getServerInfo();
        System.out.println(serverInfo);//Apache Tomcat/9.0.48


        return true;
    }
}
