package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.InstanceBuildRequest;
import com.github.justgame.springmvctest.pipeline.InstanceBuildContext;
import com.github.justgame.springmvctest.pipeline.PipelineExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiecongle
 * @date 2020/12/22
 */
@Service
public class ModelService {

    @Resource
    private PipelineExecutor executor;

    public String buildModuleInstance(InstanceBuildRequest request) {
        InstanceBuildContext context = createPipelineDate(request);
        boolean success = executor.acceptSync(context);
        if (success) {
            return "success";
        }
        return context.getErrorMsg();
    }

    private InstanceBuildContext createPipelineDate(InstanceBuildRequest request) {
        InstanceBuildContext context = new InstanceBuildContext();
        context.setModelId(request.getModelId());
        context.setUserId(request.getUserId());
        context.setFormInput(request.getFormInput());
        return context;
    }
}
