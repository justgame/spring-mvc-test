package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.entity.CommonValidationRequest;
import com.github.justgame.springmvctest.entity.NestedValidationRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {
    @PostMapping("/nested")
    public void nestedValidate(@Valid @RequestBody NestedValidationRequest request) {
        System.out.println(request);
        System.out.println("success");
    }

    @GetMapping
    public void commonValidate(@Valid CommonValidationRequest request) {
        System.out.println(request);
        System.out.println("success");
    }
}
