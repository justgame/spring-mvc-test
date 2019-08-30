package com.github.justgame.springmvctest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringMvcTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcTestApplication.class, args);
    }

    @Bean
    public Cache cache(CacheManager cacheManager) {
        return cacheManager.getCache("caffeine");
    }
}
