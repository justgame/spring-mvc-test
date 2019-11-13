package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.component.strategy.StrategyFactory;
import com.github.justgame.springmvctest.component.strategy.StrategyInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XieCl
 * @date 2019/11/14 0:15
 */
@Service
public class StrategyService {
    @Autowired
    private StrategyFactory strategyFactory;

    public void print(String strategy) {
        StrategyInstance strategyInstance = strategyFactory.getStrategy(strategy);
        if (strategyInstance == null) {
            System.out.println("nothing to print");
        } else {
            strategyInstance.print();
        }
    }
}
