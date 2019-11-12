package me.shawn.polar.gentoo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/session")
@SpringBootApplication
public class GentooApplication {

    public static void main(String[] args) {
        SpringApplication.run(GentooApplication.class, args);
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping("/whoami")
    public String test(HttpSession httpSession, HttpServletRequest request) {
        log.info("Session id.... {}", httpSession.getId());
        log.info("cookie... ");
//        Arrays.stream(request.getCookies()).forEach(c -> log.info("  {}: {}", c.getName(), c.getValue()));
        return String.format("session ID: %s", httpSession.getId());
    }

    @GetMapping
    public String ok() {
        return "OK...";

    }

    @Value("${spring.redis.host:localhost}")
    private String redisHost;

    @Value("${spring.redis.port:6379}")
    private int redisPort;

    @Primary
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        log.info("Creating RedisConnectionFactory {}:{}", redisHost, redisPort);
        return new LettuceConnectionFactory(redisHost, redisPort);
    }

    @Primary
    @Bean
    public RedisTemplate<?, ?> objectRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

}
