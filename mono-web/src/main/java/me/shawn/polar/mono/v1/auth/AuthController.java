package me.shawn.polar.mono.v1.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/ping")
    public void ping() {

    }
}
