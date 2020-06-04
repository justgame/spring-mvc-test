package com.github.justgame.springmvctest.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiecongle
 * @date 2020/6/3
 */
@Service
public class HasToLogService implements ApplicationContextAware, InitializingBean {
    private Map<String, ToLogService> toLogServiceMap = new HashMap<>();

    private Map<String, IService> serviceMap = new HashMap<>();

    private ApplicationContext context;

    public void registerToLogService(String name, ToLogService toLogService) {
        toLogServiceMap.put(name, toLogService);
    }

    public void doSomething() {
        System.out.println("this is hasToLogService");
//        toLogServiceMap.forEach((k, v) -> v.doSomething());
        serviceMap.forEach((k, v) -> v.doSomething());
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, IService> map = context.getBeansOfType(IService.class);
        serviceMap.putAll(map);
    }
}
