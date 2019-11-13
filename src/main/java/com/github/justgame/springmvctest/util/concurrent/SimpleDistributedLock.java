package com.github.justgame.springmvctest.util.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author XieCl
 * @date 2019/10/15 17:38
 */
@Component
@Slf4j
public class SimpleDistributedLock {
    private final StringRedisTemplate redis;

    public SimpleDistributedLock(StringRedisTemplate redis) {
        this.redis = redis;
    }

    public void lock(String key) {
        do {
            Boolean acquired = redis.opsForValue().setIfAbsent(key, "1", 1, TimeUnit.DAYS);
            if (acquired == null) {
                throw new IllegalStateException();
            }
            if (!acquired) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
            } else {
                break;
            }
        } while (true);
    }

    public boolean tryLock(String key) {
        Boolean acquired = redis.opsForValue().setIfAbsent(key, "1", 1, TimeUnit.DAYS);
        if (acquired == null) {
            throw new IllegalStateException();
        }

        return acquired;
    }

    public void releaseLock(String key) {
        redis.delete(key);
    }
}
