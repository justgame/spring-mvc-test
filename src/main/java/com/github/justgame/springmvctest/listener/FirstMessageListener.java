package com.github.justgame.springmvctest.listener;

import com.github.justgame.springmvctest.event.FirstMessageEvent;
import com.github.justgame.springmvctest.message.FirstMessage;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author xiecongle
 * @date 2021/2/27
 */
@Component
public class FirstMessageListener extends AbstractMessageListener<FirstMessage, FirstMessageEvent> {
    @Override
    protected void doSomething(FirstMessageEvent event) {
        System.out.println(event.getMessage().getFirst());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
