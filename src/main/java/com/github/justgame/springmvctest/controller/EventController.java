package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.event.CallEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiecongle
 * @date 2020/12/10
 */
@RestController
@RequestMapping("/event")
@Slf4j
public class EventController {
    @Autowired
    private ApplicationContext applicationContext;

    @PostMapping
    public void post() {
        CallEvent callEvent = new CallEvent(this);
        applicationContext.publishEvent(callEvent);
        log.info("event published.");
    }
}
