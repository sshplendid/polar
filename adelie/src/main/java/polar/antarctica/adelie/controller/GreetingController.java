package polar.antarctica.adelie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class GreetingController {


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", defaultValue = "World") final String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/check")
    public String test() {
        return "test";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    /*
    @GetMapping("/session-expire")
    public void expireSession(HttpServletRequest req, String sessionId) {
        HttpSession session = req.getSession();

    }

     */
}
