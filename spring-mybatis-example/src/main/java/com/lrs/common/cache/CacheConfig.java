package com.lrs.common.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class CacheConfig {

    @Value("${redis.host}")
    private String host ;

    @Value("${redis.port}")
    private int port;

    @Bean
    public RedisStandaloneConfiguration standaloneConfiguration(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPort(port);
        return configuration;
    }

    @Bean
    public LettuceClientConfiguration clientConfiguration(){
        return LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(10))
        .build();
    }

    @Bean
    public RedisConnectionFactory connectionFactory(RedisStandaloneConfiguration standaloneConfiguration,LettuceClientConfiguration lettuceClientConfiguration) {
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(standaloneConfiguration,lettuceClientConfiguration);
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
