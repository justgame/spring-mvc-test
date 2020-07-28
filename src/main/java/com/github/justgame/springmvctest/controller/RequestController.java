package com.github.justgame.springmvctest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiecongle
 * @date 2020/7/21
 */
@RestController
@RequestMapping("/request")
public class RequestController {
    @GetMapping("/header")
    public void requestHeaderEncode(@RequestHeader String id, @RequestHeader String name) {
        System.out.println(id);
        System.out.println(name);
    }

    // todo url pattern 测试
}
