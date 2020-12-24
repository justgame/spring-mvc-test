package com.github.justgame.springmvctest.pipeline;

import lombok.Data;

import java.util.Map;

/**
 * @author xiecongle
 * @date 2020/12/22
 */
@Data
public class InstanceBuildContext extends PipelineContext {
    private Long modelId;

    private Long userId;

    private Map<String, Object> formInput;

    private Long instanceId;

    private String errorMsg;

    @Override
    public String getName() {
        return "模型实例构建上下文";
    }
}
