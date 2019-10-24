package com.github.justgame.springmvctest.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author XieCl
 * @date 2019/10/24 11:02
 */
@Component
public class PrintScheduler {
    @Scheduled(fixedRate = 1000)
    public void print() {
        System.out.println("print " + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
