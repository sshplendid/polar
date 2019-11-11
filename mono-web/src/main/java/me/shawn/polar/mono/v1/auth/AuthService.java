package me.shawn.polar.mono.v1.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;

@Service
public class AuthService {

    @Autowired
    AuthRedisRepository authRedisRepository;

    public AuthResultModel authenticate(AuthLoginModel authLogin) throws IllegalAccessException {
        if(StringUtils.equals(authLogin.getId(), "shawn") && StringUtils.equals(authLogin.getPassword(), "1234")) {
            AuthResultModel authResult =  AuthResultModel.builder().id(authLogin.getId()).logInAt(LocalDateTime.now()).build();
            authRedisRepository.save(authResult);

            return authResult;
        }
        throw new IllegalAccessException("로그인 실패");
    }

    public AuthResultModel findAuthModelBySessionId(String sid) {
        return authRedisRepository.findById(sid).orElse(AuthResultModel.NONE);
    }

}
