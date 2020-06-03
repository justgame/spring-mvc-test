package com.github.justgame.springmvctest.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiecongle
 * @date 2020/6/3
 */
@Service
public class HasToLogService {
    private Map<String, ToLogService> toLogServiceMap = new HashMap<>();


    public void registerToLogService(String name, ToLogService toLogService) {
        toLogServiceMap.put(name, toLogService);
    }

    public void doSomething() {
        System.out.println("this is hasToLogService");
        toLogServiceMap.forEach((k, v) -> v.doSomething());
    }
}
