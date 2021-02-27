package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.event.CallEvent;
import com.github.justgame.springmvctest.event.FirstMessageEvent;
import com.github.justgame.springmvctest.event.SecondMessageEvent;
import com.github.justgame.springmvctest.message.FirstMessage;
import com.github.justgame.springmvctest.message.SecondMessage;
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

    @PostMapping("/first")
    public void firstEvent() {
        FirstMessage firstMessage = new FirstMessage();
        firstMessage.setFirst("first");
        FirstMessageEvent firstMessageEvent = new FirstMessageEvent(this, firstMessage);
        applicationContext.publishEvent(firstMessageEvent);
        log.info("event published.");
    }

    @PostMapping("/second")
    public void secondEvent() {
        SecondMessage secondMessage = new SecondMessage();
        secondMessage.setSecond("second");
        SecondMessageEvent secondMessageEvent = new SecondMessageEvent(this, secondMessage);
        applicationContext.publishEvent(secondMessageEvent);
        log.info("event published.");
    }
}
