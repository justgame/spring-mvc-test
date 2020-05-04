package com.github.justgame.springmvctest.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieCl
 * @date 2020/5/4 1:41
 */
@RestController
@RequestMapping("/security")
public class SecurityController {
    @GetMapping
    public String security(@AuthenticationPrincipal User user) {
        System.out.println(user);
        return "success";
    }
}
