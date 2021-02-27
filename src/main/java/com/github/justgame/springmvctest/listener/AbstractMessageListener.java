package com.github.justgame.springmvctest.listener;

import com.alibaba.fastjson.JSON;
import com.github.justgame.springmvctest.event.BaseMessageEvent;
import com.github.justgame.springmvctest.message.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @author xiecongle
 * @date 2021/2/27
 */
public abstract class AbstractMessageListener<K extends BaseMessage, T extends BaseMessageEvent<K>> implements ApplicationListener<T> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Async("threadPoolTaskExecutor")
    @Override
    public void onApplicationEvent(T event) {
        log.info("start event[{}]={}", event.getClass().getSimpleName(), JSON.toJSONString(event));
        doSomething(event);
        log.info("finish event[{}]={}", event.getClass().getSimpleName(), JSON.toJSONString(event));
    }

    protected abstract void doSomething(T event);
}
