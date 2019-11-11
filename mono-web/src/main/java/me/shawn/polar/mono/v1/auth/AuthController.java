package me.shawn.polar.mono.v1.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResultModel logIn(HttpSession httpSession, @RequestBody AuthLoginModel authLogin) throws IllegalAccessException {
        String sid = httpSession.getId();
        AuthResultModel authResult = authService.authenticate(sid, authLogin);
        httpSession.setAttribute("userInfo", authResult);

        return authResult;
    }
}
