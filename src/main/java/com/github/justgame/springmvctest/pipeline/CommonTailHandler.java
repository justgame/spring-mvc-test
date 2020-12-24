package com.github.justgame.springmvctest.pipeline;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author xiecongle
 * @date 2020/12/23
 */
@Component
@Slf4j
public class CommonTailHandler implements ContextHandler<PipelineContext> {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public boolean handle(PipelineContext context) {
        context.setFinishTime(LocalDateTime.now());
        try {
            log.info("管道执行结束: context={}", objectMapper.writeValueAsString(context));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
