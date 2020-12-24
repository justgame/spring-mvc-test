package com.github.justgame.springmvctest.pipeline;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * @author xiecongle
 * @date 2020/12/22
 */
@Component
@Slf4j
public class PipelineExecutor {
    @Resource
    private Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? super PipelineContext>>>
    pipelineRouteMap;

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    private CommonHeadHandler commonHeadHandler;

    @Resource
    private CommonTailHandler commonTailHandler;

    public boolean acceptSync(PipelineContext context) {
        Objects.requireNonNull(context, "上下文数据不能为空");

        Class<? extends PipelineContext> dataType = context.getClass();

        List<? extends ContextHandler<? super PipelineContext>> pipeline = pipelineRouteMap.get(dataType);
        if (CollectionUtils.isEmpty(pipeline)) {
            log.error("{}的管道为空", context.getName());
            return false;
        }

        commonHeadHandler.handle(context);

        boolean lastSuccess = true;
        for (ContextHandler<? super PipelineContext> handler : pipeline) {
            try {
                lastSuccess = handler.handle(context);
            } catch (Exception e) {
                lastSuccess = false;
                log.error("[{}]处理异常, handler={}", context.getName(), handler.getClass().getSimpleName());
            }

            if (!lastSuccess) {
                break;
            }
        }

        commonTailHandler.handle(context);

        return lastSuccess;
    }

    public void acceptAsync(PipelineContext context, BiConsumer<PipelineContext, Boolean> callback) {
        threadPoolTaskExecutor.execute(() -> {
            boolean success = acceptSync(context);

            if (callback != null) {
                callback.accept(context, success);
            }
        });
    }
}
