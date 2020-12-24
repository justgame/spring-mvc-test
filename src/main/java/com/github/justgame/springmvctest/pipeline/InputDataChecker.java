package com.github.justgame.springmvctest.pipeline;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author xiecongle
 * @date 2020/12/22
 */
@Component
@Slf4j
public class InputDataChecker implements ContextHandler<InstanceBuildContext> {
    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("输入数据校验");

        Map<String, Object> formInput = context.getFormInput();

        if (CollectionUtils.isEmpty(formInput)) {
            context.setErrorMsg("表单输入数据不能为空");
            return false;
        }

        String instanceName = (String) formInput.get("instanceName");
        if (StringUtils.isEmpty(instanceName)) {
            context.setErrorMsg("表单输入数据必须包含实例名称");
            return false;
        }

        return true;
    }
}
