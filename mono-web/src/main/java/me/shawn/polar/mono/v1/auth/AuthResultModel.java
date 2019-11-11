package me.shawn.polar.mono.v1.auth;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@RedisHash("authResult")
@Data @Builder
public class AuthResultModel implements Serializable {
    @Id
    private String sid;
    private String id;
    private String password;
    private LocalDateTime logInAt;

    public static final AuthResultModel NONE = AuthResultModel.builder().id("NONE").build();
}
