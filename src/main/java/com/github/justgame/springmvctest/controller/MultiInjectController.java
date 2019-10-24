package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.service.multi.MultiInjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieCl
 * @date 2019/10/24 14:29
 */
@RestController
public class MultiInjectController {
    @Autowired
    @Qualifier("multiInjectServiceImpl1")
    private MultiInjectService multiInjectService;

    @GetMapping("/multiInject")
    public void multiInject() {
        multiInjectService.print();
    }
}
