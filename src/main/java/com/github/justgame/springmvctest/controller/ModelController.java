package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.entity.InstanceBuildRequest;
import com.github.justgame.springmvctest.service.ModelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiecongle
 * @date 2020/12/23
 */
@RestController
@RequestMapping("/model")
public class ModelController {
    @Resource
    private ModelService modelService;

    @PostMapping
    public String create(@RequestBody InstanceBuildRequest request) {
        return modelService.buildModuleInstance(request);
    }
}
