package com.github.justgame.springmvctest.component.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author XieCl
 * @date 2019/11/14 0:19
 */
@Component
public class PrintWorldStrategy implements StrategyInstance {
    @Value("${strategy.print.world:}")
    private String strategyName;

    @Override
    public String getStrategyName() {
        return strategyName;
    }

    @Override
    public void print() {
        System.out.println("world");
    }
}
