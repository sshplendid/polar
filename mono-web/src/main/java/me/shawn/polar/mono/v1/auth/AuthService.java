package me.shawn.polar.mono.v1.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;

@Slf4j
@Service
public class AuthService {

    @Autowired
    AuthRedisRepository authRedisRepository;

    public AuthResultModel authenticate(String sessionId, AuthLoginModel authLogin) throws IllegalAccessException {
        if(StringUtils.equals(authLogin.getId(), "shawn") && StringUtils.equals(authLogin.getPassword(), "1234")) {
            AuthResultModel authResult =  AuthResultModel.builder().sid(sessionId).id(authLogin.getId()).logInAt(LocalDateTime.now()).build();
            authRedisRepository.save(authResult);
            log.info("saved auth result: {}", authResult);

            return authResult;
        }
        throw new IllegalAccessException("로그인 실패");
    }

    public AuthResultModel findAuthModelBySessionId(String sid) {
        log.info("find auth model by sid: {}", sid);
        return authRedisRepository.findById(sid).orElse(AuthResultModel.NONE);
    }

}
