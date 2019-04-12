package polar.antarctica.ocean.bluewhale.greeting;

import lombok.*;

import java.time.LocalDateTime;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class GreetingCard {
    private String name;
    private String message;
    private LocalDateTime sentDate;
}
