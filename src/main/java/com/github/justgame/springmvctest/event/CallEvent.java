package com.github.justgame.springmvctest.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author xiecongle
 * @date 2020/12/10
 */
public class CallEvent extends ApplicationEvent {

    public CallEvent(Object source) {
        super(source);
    }
}
