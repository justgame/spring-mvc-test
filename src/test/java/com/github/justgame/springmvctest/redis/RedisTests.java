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
import java.util.Set;

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
        // System.out.println(keys);
    }
}
