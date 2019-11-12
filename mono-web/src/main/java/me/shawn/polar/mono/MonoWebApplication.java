package me.shawn.polar.mono;

import me.shawn.polar.mono.v1.point.Point;
import me.shawn.polar.mono.v1.point.PointRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class MonoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonoWebApplication.class, args);
    }

    @Autowired
    private PointRedisRepository pointRedisRepository;

    @Bean
    public CommandLineRunner mockData() {
        return args -> {
            Point point = Point.builder()
                    .id("홍길동")
                    .amount(123L)
                    .refreshedAt(LocalDateTime.now())
                    .build();

            pointRedisRepository.save(point);

        };
    }

}
