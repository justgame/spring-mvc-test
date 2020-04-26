package com.github.justgame.springmvctest.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author xiecongle
 * @date 2020/4/26
 */
@Data
@Accessors(chain = true)
public class JsonResponse {
    private Long id;

    private String nullStr;

    private Date time;
}
