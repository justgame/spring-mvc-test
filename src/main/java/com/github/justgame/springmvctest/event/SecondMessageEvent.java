package com.github.justgame.springmvctest.event;

import com.github.justgame.springmvctest.message.SecondMessage;

/**
 * @author xiecongle
 * @date 2021/2/27
 */
public class SecondMessageEvent extends BaseMessageEvent<SecondMessage> {
    public SecondMessageEvent(Object source, SecondMessage message) {
        super(source, message);
    }
}
