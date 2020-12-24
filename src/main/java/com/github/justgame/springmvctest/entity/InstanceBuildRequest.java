package com.github.justgame.springmvctest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author xiecongle
 * @date 2020/12/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstanceBuildRequest {
    private Long modelId;

    private Long userId;

    private Map<String, Object> formInput;
}
