package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.aspect.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author xiecongle
 * @date 2020/6/3
 */
@Service
public class ToLogService {
    @Autowired
    private HasToLogService hasToLogService;

    @Log
    public void doSomething() {
        System.out.println("this is toLogService");
    }

    @PostConstruct
    public void init() {
        hasToLogService.registerToLogService("toLogService", this);
    }
}
