package com.github.justgame.springmvctest.pipeline;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xiecongle
 * @date 2020/12/22
 */
@Data
public class PipelineContext {
    private LocalDateTime startTime;

    private LocalDateTime finishTime;

    public String getName() {
        return getClass().getSimpleName();
    }
}
