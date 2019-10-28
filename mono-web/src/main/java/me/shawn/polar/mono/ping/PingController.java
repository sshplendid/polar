package me.shawn.polar.mono.ping;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RequestMapping("/ping")
@RestController
public class PingController {

    @Value("${polar.env.foo:none}")
    private String env;

    @GetMapping
    public LocalHostModel ping() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String canonicalHostName = InetAddress.getLocalHost().getCanonicalHostName();

        return LocalHostModel.builder()
                .canonicalHostName(canonicalHostName)
                .hostAddress(hostAddress)
                .hostName(hostName)
                .build();
    }

    @GetMapping("/profile")
    public String checkProfile() {
        return String.format("Profile of this application: '%s'", env);
    }
}
