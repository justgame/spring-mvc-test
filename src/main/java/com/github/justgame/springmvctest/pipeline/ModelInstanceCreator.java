package com.github.justgame.springmvctest.pipeline;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xiecongle
 * @date 2020/12/22
 */
@Component
@Slf4j
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {

    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("创建实例");
        // do something
        return true;
    }
}
