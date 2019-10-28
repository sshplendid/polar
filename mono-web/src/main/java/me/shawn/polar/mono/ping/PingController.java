package me.shawn.polar.mono.ping;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ping")
@RestController
public class PingController {

    @Value("${spring.profiles.active:none}")
    private String profiles;

    @GetMapping
    public LocalHostModel ping() {
        return new LocalHostModel();
    }

    @GetMapping("/profile")
    public String checkProfile() {
        return String.format("Profile of this application: '%s'", profiles);
    }
}
