package com.lrs.common.cache;

import org.springframework.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class CacheConfig {

    @Bean
    public RedisConnectionFactory connectionFactory() {
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory("localhost", 6379);
        return connectionFactory;
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

        Set<String> cacheNames = new HashSet<>();

        cacheNames.add("area");

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(cacheConfig())
                .initialCacheNames(cacheNames)
                .transactionAware()
                .build();
    }

    public RedisCacheConfiguration cacheConfig() {

        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(30))
                .disableCachingNullValues();
    }
}
