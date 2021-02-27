package com.github.justgame.springmvctest.listener;

import com.github.justgame.springmvctest.event.SecondMessageEvent;
import com.github.justgame.springmvctest.message.SecondMessage;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author xiecongle
 * @date 2021/2/27
 */
@Component
public class SecondMessageListener extends AbstractMessageListener<SecondMessage, SecondMessageEvent> {
    @Override
    protected void doSomething(SecondMessageEvent event) {
        System.out.println(event.getMessage().getSecond());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
