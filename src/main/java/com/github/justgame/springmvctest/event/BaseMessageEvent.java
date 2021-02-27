package com.github.justgame.springmvctest.event;

import com.github.justgame.springmvctest.message.BaseMessage;
import org.springframework.context.ApplicationEvent;

/**
 * @author xiecongle
 * @date 2021/2/27
 */
public class BaseMessageEvent<T extends BaseMessage> extends ApplicationEvent {

    private T message;
    
    public BaseMessageEvent(Object source, T message) {
        super(source);
        this.message = message;
    }

    public T getMessage() {
        return message;
    }
}
