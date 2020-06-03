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
public class HasToLogServiceTest {
    @Autowired
    private HasToLogService hasToLogService;

    /**
     * 这个测试可以看出通过bean init方法将bean注册到其他bean的域中，该bean的aop不会生效
     */
    @Test
    public void testDoSomething() {
        hasToLogService.doSomething();
    }
}