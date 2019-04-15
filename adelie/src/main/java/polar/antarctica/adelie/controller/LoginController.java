package polar.antarctica.adelie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Value("${server.servlet.context-path}")
    private String CONTEXT_PATH;

    @GetMapping("/loginView")
    public String login() {
        return "login";
    }

    @GetMapping("/login")
    public String setSession(HttpServletRequest req, HttpServletResponse res, String accountId, String name, Model model) throws IOException {
        log.info("로그인 시도중... {} / {}", accountId, name);

        if(accountId != null && name != null) {
            HttpSession session = req.getSession();
            session.setAttribute("accountId", accountId);
            session.setAttribute("name", name);
            session.setAttribute("loginDate", LocalDateTime.now());

        res.sendRedirect(CONTEXT_PATH + "/login/getStatus");
        } else {
            model.addAttribute("status", "NOT_AUTHORIZED");
            return "WRONG_USER";
        }
        return "index";
    }

    @GetMapping("/getStatus")
    public String getSessionInfo(HttpSession session, Model model) {
        String accountId = (String) session.getAttribute("accountId");
        String name = (String) session.getAttribute("name");
        log.info("세션 정보 조회 시도중... {} / {}", accountId, name);

        model.addAttribute("accountId", accountId);
        model.addAttribute("name", name);
        model.addAttribute("loginDate", session.getAttribute("loginDate"));

        model.addAttribute("status", "LOGIN");
        return "greeting";
    }

    @GetMapping("/expire")
    public String completSessionStatus(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("status", "EXPIRED");


        return"session";
    }
}
