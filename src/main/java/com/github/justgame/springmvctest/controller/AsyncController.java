package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieCl
 * @date 2019/10/24 10:58
 */
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async() {
        asyncService.async();
    }
}
