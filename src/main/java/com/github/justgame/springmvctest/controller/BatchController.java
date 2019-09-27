package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.entity.BatchTagsRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xcl
 * @date 2019/9/25
 */
@RestController
public class BatchController {
    @GetMapping("/batch/tags")
    public List<Long> tags(BatchTagsRequest request) {
        return request.getTags();
    }

    @GetMapping("/batch/tags2/{tags}")
    public List<Long> tags2(@PathVariable List<Long> tags) {
        return tags;
    }

    @GetMapping("/batch/tags3")
    public List<Long> tags3(@RequestParam List<Long> tags) {
        return tags;
    }
}
