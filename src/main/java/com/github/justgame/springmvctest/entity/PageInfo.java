package com.github.justgame.springmvctest.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author XieCl
 * @date 2020/5/5 1:46
 */
@Component
@ConfigurationProperties(prefix = "page")
@Data
@Validated
public class PageInfo {
    @Max(value = 10, message = "the page size must not large then 10")
    @Min(value = 5, message = "the page size must not small than 5")
    private int pageSize = 5;
}
