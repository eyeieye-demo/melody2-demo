package com.eyeieye.melody.demo.web.interceptor;

import com.eyeieye.melos.servlet.HandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UrlInterceptor extends HandlerInterceptorAdapter
        implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UrlInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod == false) {
            StringBuffer sf = new StringBuffer();
            sf.append("\n")
                    .append("·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-[URL级别拦截器]·-·-·-·-·-·-·-·-·--·-·-·-·-·-·-·-·-·-·-·-·")
                    .append("\n")
                    .append("·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·[接收到请求]·-·-·-·-·-·-·-·-·-·--·-·-·-·-·-·-·-·-·-·-·-·")
                    .append("\n")
                    .append("·                                                                                                ·")
                    .append("\n")
                    .append("·                                           请求链接                                              ·")
                    .append("\n")
                    .append(request.getRequestURL())
                    .append("\n")
                    .append("·                                           请求参数                                              ·")
                    .append("\n")
                    .append(request.getQueryString())
                    .append("\n")
                    .append("·                                           请求IP                                                ·")
                    .append("\n")
                    .append(request.getRemoteAddr());

            logger.debug(sf.toString());
        }
        super.preHandle(request,response,handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (handler instanceof HandlerMethod == false) {
            StringBuffer sf = new StringBuffer();
            sf.append("\n")
                    .append("·                                          返回状态码                                             ·")
                    .append("\n")
                    .append(response.getStatus())
                    .append("\n")
                    .append("·                                                                                                ·")
                    .append("\n")
                    .append("·                                                                                                ·")
                    .append("\n")
                    .append("·                                                                                                ·")
                    .append("\n")
                    .append("·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-·-[请求返回]-·-·-·-·-·-·-·-·-·-·--·-·-·-·-·-·-·-·-·-·-·-·")
                    .append("\n");
            logger.debug(sf.toString());
        }
        super.postHandle(request, response, handler, modelAndView);

    }
}
