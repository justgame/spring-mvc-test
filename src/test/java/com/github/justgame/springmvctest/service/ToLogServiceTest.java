package com.github.justgame.springmvctest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author xiecongle
 * @date 2020/6/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ToLogServiceTest {
    @Autowired
    private ToLogService toLogService;

    @Test
    public void testDoSomething() {
        toLogService.doSomething();
    }
}