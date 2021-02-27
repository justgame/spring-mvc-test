package com.github.justgame.springmvctest.event;

import com.github.justgame.springmvctest.message.FirstMessage;

/**
 * @author xiecongle
 * @date 2021/2/27
 */
public class FirstMessageEvent extends BaseMessageEvent<FirstMessage> {
    public FirstMessageEvent(Object source, FirstMessage message) {
        super(source, message);
    }
}
