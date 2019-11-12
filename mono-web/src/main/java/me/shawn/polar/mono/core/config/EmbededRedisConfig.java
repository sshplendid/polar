package me.shawn.polar.mono.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Profile("embeded-redis")
@Configuration
public class EmbededRedisConfig {

    @Value("${spring.redis.port:6379}")
    private int redisPort;

    private RedisServer redisServer;

    @PostConstruct
    public void startRedisServer() {
        log.info(String.format("Starting embeded redis server at port %d ...", redisPort));
        redisServer = new RedisServer(redisPort);
        redisServer.start();
    }

    @PreDestroy
    public void stopRedisServer() {
        if(redisServer != null) {
            redisServer.stop();
        }
    }
}
