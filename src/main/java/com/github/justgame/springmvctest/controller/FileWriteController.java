package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.service.FileWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieCl
 * @date 2020/5/5 17:24
 */
@RestController
@RequestMapping("/file/write")
public class FileWriteController {
    @Autowired
    private FileWriteService fileWriteService;

    @PostMapping
    public void write(String data) {
        fileWriteService.write(data);
    }
}
