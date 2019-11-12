package me.shawn.polar.mono.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Profile("redis")
@Slf4j
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host:localhost}")
    private String redisHost;

    @Value("${spring.redis.port:6379}")
    private int redisPort;

    @Primary
    @Bean
    public RedisConnectionFactory objectRedisConnectionFactory() {
        log.info("Creating RedisConnectionFactory {}:{}", redisHost, redisPort);
        return new LettuceConnectionFactory(redisHost, redisPort);
    }

    @Primary
    @Bean
    public RedisTemplate<?, ?> objectRedisTemplate(RedisConnectionFactory objectRedisConnectionFactory) {
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(objectRedisConnectionFactory);
        return redisTemplate;
    }
}
