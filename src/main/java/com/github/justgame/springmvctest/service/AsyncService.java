package com.github.justgame.springmvctest.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author XieCl
 * @date 2019/10/24 10:59
 */
@Service
public class AsyncService {
    @Async
    public void async() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("async");
    }
}
