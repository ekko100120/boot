package com.mecury.boot.controller.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter{
    public AuthInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (log.isInfoEnabled()){
            log.info("--------------AuthInterceptor is preHandle ing---------------");
        }
        HandlerMethod method = (HandlerMethod) handler;
        Class<?> clazz = method.getBeanType();
        AuthValidator methodValidator = method.getMethodAnnotation(AuthValidator.class);
        AuthValidator clazzValidator = method.getMethodAnnotation(AuthValidator.class);
        if (methodValidator==null||!methodValidator.check()||!clazzValidator.check()){
            return true;
        }
        if (methodValidator.name().equals("admin")){
            return  true;
        }else if (methodValidator.name().equals("kenny")){
            response.sendRedirect("/hello");
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);

            log.info("--------response status:"+response.getStatus()+"-------------");
            log.info("--------response header:"+response.getContentType()+"-------------");
            return  false;
        }else {
            response.sendRedirect("/hello");
            return  false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
