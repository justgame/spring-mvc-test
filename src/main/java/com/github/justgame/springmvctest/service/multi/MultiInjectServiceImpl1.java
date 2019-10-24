package com.github.justgame.springmvctest.service.multi;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author XieCl
 * @date 2019/10/24 14:28
 */
@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MultiInjectServiceImpl1 implements  MultiInjectService {
    @Override
    public void print() {
        System.out.println("multiInject1");
    }
}
