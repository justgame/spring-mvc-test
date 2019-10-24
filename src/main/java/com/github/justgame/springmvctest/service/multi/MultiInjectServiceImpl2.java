package com.github.justgame.springmvctest.service.multi;

import org.springframework.stereotype.Service;

/**
 * @author XieCl
 * @date 2019/10/24 14:28
 */
@Service
public class MultiInjectServiceImpl2 implements MultiInjectService {
    @Override
    public void print() {
        System.out.println("multiInject2");
    }
}
