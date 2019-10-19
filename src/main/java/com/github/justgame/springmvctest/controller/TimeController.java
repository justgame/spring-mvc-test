package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.entity.TimeVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieCl
 * @date 2019/10/19 14:50
 */
@RestController
public class TimeController {
    @PostMapping("/time")
    public TimeVo saveTime(@RequestBody TimeVo timeVo) {
        System.out.println(timeVo);
        return timeVo;
    }
}
