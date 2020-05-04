package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.entity.Good;
import com.github.justgame.springmvctest.entity.PageInfo;
import com.github.justgame.springmvctest.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieCl
 * @date 2020/5/5 2:04
 */
@RestController
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    private PageInfo pageInfo;

    @Autowired
    private GoodService goodService;

    @GetMapping
    public Page<Good> list(@RequestParam(required = false, defaultValue = "0") int page) {
        return goodService.list(page, pageInfo.getPageSize());
    }
}
