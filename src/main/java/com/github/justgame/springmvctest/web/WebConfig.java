package com.github.justgame.springmvctest.web;

import com.github.justgame.springmvctest.interceptor.UserNameInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiecongle
 * @date 2020/5/1
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private UserNameInterceptor userNameInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userNameInterceptor).addPathPatterns("/**");
    }
}
