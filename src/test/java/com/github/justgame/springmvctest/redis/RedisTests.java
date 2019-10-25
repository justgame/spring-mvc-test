package com.github.justgame.springmvctest.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author XieCl
 * @date 2019/10/24 23:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private StringRedisTemplate redis;

    @Test
    public void testScan() {
        Set<String> keys = new HashSet<>();
        String matchPattern = "exam:*";
        redis.execute((RedisConnection connection) -> {
            Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().match(matchPattern).build());
            while (cursor.hasNext()) {
                keys.add(new String(cursor.next()));
            }
            return null;
        });
        System.out.println(keys.size());
        System.out.println(keys);
    }

    @Test
    public void testExamCachePrune() {
        List<Long> idList = IntStream.range(0, 10).mapToObj(Long::valueOf).collect(Collectors.toList());
        idList.forEach(this::cachePrune);
    }

    private void cachePrune(Long id) {
        Set<String> cacheKeys = new HashSet<>();
        String matchPattern1 = String.format("exam:%s:user%s:record", id, "*");
        redis.execute((RedisConnection connection) -> {
            Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().match(matchPattern1).build());
            while (cursor.hasNext()) {
                cacheKeys.add(new String(cursor.next()));
            }
            return null;
        });

        String matchPattern2 = String.format("exam:%s:user%s:record_item:newest", id, "*");
        redis.execute((RedisConnection connection) -> {
            Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().match(matchPattern2).build());
            while (cursor.hasNext()) {
                cacheKeys.add(new String(cursor.next()));
            }
            return null;
        });

        cacheKeys.forEach(this::cachePrune0);
    }

    private void cachePrune0(String key) {
        Long expire = redis.getExpire(key);
        if (expire != null && expire == -1L) {
            redis.expire(key, 7, TimeUnit.DAYS);
        }
    }
}
