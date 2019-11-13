package com.github.justgame.springmvctest.concurrent;

import com.github.justgame.springmvctest.util.concurrent.SimpleDistributedLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author XieCl
 * @date 2019/10/26 16:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleDistributedLockTest {
    @Autowired
    private SimpleDistributedLock lock;

    @Test
    public void test20Concurrency() {

    }

    private void doWork() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do work");
    }

    static class Work {
        private final CountDownLatch latch;

        Work(CountDownLatch latch) {
            this.latch = latch;
        }


    }
}
