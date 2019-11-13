package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieCl
 * @date 2019/11/14 0:14
 */
@RestController
@RequestMapping("/strategy")
public class StrategyController {
    @Autowired
    private StrategyService strategyService;

    @GetMapping("/print")
    public void print(String strategy) {
        strategyService.print(strategy);
    }
}
