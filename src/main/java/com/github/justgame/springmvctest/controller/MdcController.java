package com.github.justgame.springmvctest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiecongle
 * @date 2020/5/1
 */
@RestController
@RequestMapping("/mdc")
@Slf4j
public class MdcController {
    @GetMapping
    public String mdc(@RequestHeader("my-username") String username) {
        if (log.isInfoEnabled()) {
            log.info("access mdc controller with username: {}", username);
        }
        return "success";
    }
}
