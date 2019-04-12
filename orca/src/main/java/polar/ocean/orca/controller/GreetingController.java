package polar.ocean.orca.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import polar.antarctica.ocean.bluewhale.greeting.GreetingCard;
import polar.antarctica.ocean.bluewhale.greeting.GreetingFormatter;

import java.time.LocalDateTime;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public ResponseEntity<GreetingCard> sayHello(String name) {
        String message = GreetingFormatter.format(name);
        GreetingCard card = GreetingCard.builder()
                .name(name)
                .message(message)
                .sentDate(LocalDateTime.now())
                .build();
        ResponseEntity<GreetingCard> res = ResponseEntity.ok(card);
        return res;
    }
}
