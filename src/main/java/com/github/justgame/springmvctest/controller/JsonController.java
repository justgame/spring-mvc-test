package com.github.justgame.springmvctest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.justgame.springmvctest.entity.JsonRequest;
import com.github.justgame.springmvctest.entity.JsonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiecongle
 * @date 2020/4/26
 */
@RestController
@RequestMapping("/json")
public class JsonController {
    private ObjectMapper objectMapper;

    public JsonController() {
        objectMapper = new ObjectMapper();
    }

    @PostMapping
    public JsonResponse json(@RequestBody JsonRequest request) throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(request));
        JsonResponse response = new JsonResponse().setId(request.getId()).setTime(request.getTime());
        System.out.println(objectMapper.writeValueAsString(response));
        return response;
    }
}
