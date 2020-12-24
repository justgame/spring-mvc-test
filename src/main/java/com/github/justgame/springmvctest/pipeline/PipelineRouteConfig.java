package com.github.justgame.springmvctest.pipeline;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xiecongle
 * @date 2020/12/22
 */
@Configuration
public class PipelineRouteConfig implements ApplicationContextAware {
    private static final
    Map<Class<? extends PipelineContext>, List<Class<? extends ContextHandler<? extends PipelineContext>>>>
    PIPELINE_ROUTE_MAP = new HashMap<>();

    static {
        PIPELINE_ROUTE_MAP.put(InstanceBuildContext.class, Arrays.asList(
                InputDataChecker.class,
                ModelInstanceCreator.class,
                ModelInstanceSavor.class
        ));
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean("pipelineRouteMap")
    public Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>>
    pipelineRouteMap() {
        return PIPELINE_ROUTE_MAP.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, this::toPipeline));
    }

    private List<? extends ContextHandler<? extends PipelineContext>> toPipeline(
            Map.Entry<Class<? extends PipelineContext>,
                    List<Class<? extends ContextHandler<? extends PipelineContext>>>> entry) {
        return entry.getValue()
                .stream()
                .map(applicationContext::getBean)
                .collect(Collectors.toList());
    }
}
