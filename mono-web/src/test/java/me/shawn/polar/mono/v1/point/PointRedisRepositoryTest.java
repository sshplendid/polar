package me.shawn.polar.mono.v1.point;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"redis", "embeded-redis"})
@RunWith(SpringRunner.class)
@SpringBootTest
class PointRedisRepositoryTest {

    @Autowired
    private PointRedisRepository pointRedisRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void 레디스_포인트_테스트() {
        // GIVEN
        String id = "shawn";
        LocalDateTime refreshAt = LocalDateTime.now();
        Point point = Point.builder()
                .id(id)
                .refreshedAt(refreshAt)
                .amount(10L)
                .build();

        // WHEN
        pointRedisRepository.save(point);

        // THEN
        Point savedPoint = pointRedisRepository.findById(point.getId()).get();
        assertThat(savedPoint.getAmount()).isEqualTo(point.getAmount());
        assertThat(savedPoint.getRefreshedAt()).isEqualTo(point.getRefreshedAt());
    }
}