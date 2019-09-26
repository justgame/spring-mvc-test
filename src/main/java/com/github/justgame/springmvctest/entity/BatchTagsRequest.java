package com.github.justgame.springmvctest.entity;

import lombok.Data;

import java.util.List;

/**
 * @author xcl
 * @date 2019/9/25
 */
@Data
public class BatchTagsRequest {
    private List<Long> tags;
}
