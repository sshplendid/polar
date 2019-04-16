package polar.antarctica.adelie.model;


import lombok.*;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class RedisModel {
    private String key;
    private byte[] value;
}
