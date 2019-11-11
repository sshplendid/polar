package me.shawn.polar.mono.v1.point;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RedisHash("point")
public class Point {
    @Id
    private String id;
    private Long amount;
    private LocalDateTime refreshedAt;

    @Builder
    public Point(String id, Long amount, LocalDateTime refreshedAt) {
        this.id = id;
        this.amount = amount;
        this.refreshedAt = refreshedAt;
    }

    /**
     * 포인트 리프레시 타임이 모델보다 최근일 경우에만 포인트 값을 변경한다.
     * @param amount
     * @param refreshTime
     */
    public void refresh(long amount, LocalDateTime refreshTime) {
        if(refreshTime.isAfter(this.refreshedAt)) {
            this.amount = amount;
            this.refreshedAt = refreshTime;
        }
    }
}
