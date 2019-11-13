package me.shawn.polar.mono.v1.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthViewController {

    @Autowired
    AuthService authService;

    @GetMapping("/login")
    public String loginView(HttpSession httpSession, Model model) {
        String sid = httpSession.getId();
        AuthResultModel auth;
        try {
            auth = (AuthResultModel) httpSession.getAttribute("userInfo");
            log.info("session id: {}", sid);
            log.info("auth result: {}", auth.getId());
        } catch (Exception e) {
            log.error("session user info is null.");
            auth = AuthResultModel.NONE;
        }

        model.addAttribute("auth", auth);

        return "user/login";
    }
}
