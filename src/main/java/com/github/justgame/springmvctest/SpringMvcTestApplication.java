package com.github.justgame.springmvctest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
public class SpringMvcTestApplication {
    public static final String CACHE_NAME = "caffeine";

    @Value("${spring.cache.caffeine.spec:recordStats,maximumSize=300000,expireAfterWrite=10s}")
    private String caffeineSpec;
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcTestApplication.class, args);
    }

    @Bean("caffeineCacheManager")
    public CaffeineCacheManager getCaffeineCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCacheNames(Collections.singleton(CACHE_NAME));
        cacheManager.setCacheSpecification(caffeineSpec);
        cacheManager.setAllowNullValues(true);
        return cacheManager;
    }

    @Bean
    public Cache cache(@Qualifier("caffeineCacheManager") CacheManager cacheManager) {
        return cacheManager.getCache(CACHE_NAME);
    }

    @Bean
    @Profile("!prod")
    public ApplicationRunner noProdRunner() {
        return args -> System.out.println("not prod profiles active");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
