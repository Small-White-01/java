package com.lezijie.admin.intercepter;

import com.lezijie.admin.pojo.TUser;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TUser user =(TUser) request.getSession().getAttribute("user");
        if(user!=null){
          return true;
        }
        response.sendRedirect("/login");
        return false;//表示不放行资源


    }
}
