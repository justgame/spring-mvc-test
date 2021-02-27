package com.github.justgame.springmvctest.listener;

import com.github.justgame.springmvctest.event.CallEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author xiecongle
 * @date 2020/12/10
 */
@Component
@Slf4j
public class EventListener {
    @org.springframework.context.event.EventListener
    public void listenCallEvent(CallEvent callEvent) throws InterruptedException {
        log.info(callEvent.getSource().getClass() + " be called.");
        TimeUnit.SECONDS.sleep(5);
    }
}
