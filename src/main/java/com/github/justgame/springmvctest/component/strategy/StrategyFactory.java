package com.github.justgame.springmvctest.component.strategy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XieCl
 * @date 2019/11/14 0:17
 */
@Component
public class StrategyFactory implements InitializingBean, ApplicationContextAware {
    private Map<String, StrategyInstance> strategyInstanceMap;

    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() {
        strategyInstanceMap = new HashMap<>();
        Map<String, StrategyInstance> strategyInstanceMap = applicationContext.getBeansOfType(StrategyInstance.class);
        strategyInstanceMap.forEach((name, strategyInstance) -> this.strategyInstanceMap.put(strategyInstance.getStrategyName(), strategyInstance));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public StrategyInstance getStrategy(String strategy) {
        return strategyInstanceMap.get(strategy);
    }
}
