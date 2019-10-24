package com.github.justgame.springmvctest.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author XieCl
 * @date 2019/10/24 11:02
 */
@Component
public class PrintScheduler {
    @Scheduled(fixedDelay = 1000)
    public void print() {
        System.out.println("print");
    }
}
