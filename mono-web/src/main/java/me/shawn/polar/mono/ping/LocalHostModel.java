package me.shawn.polar.mono.ping;

import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
class LocalHostModel {
    private String hostName;
    private String canonicalHostName;
    private String hostAddress;
}
