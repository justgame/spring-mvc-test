package com.github.justgame.springmvctest.pipeline;

/**
 * @author xiecongle
 * @date 2020/12/22
 */
public interface ContextHandler<T extends PipelineContext> {
    boolean handle(T context);
}
