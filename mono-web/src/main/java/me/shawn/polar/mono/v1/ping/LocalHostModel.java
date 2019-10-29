package me.shawn.polar.mono.v1.ping;

import lombok.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Getter @ToString
class LocalHostModel {
    private String hostName;
    private String canonicalHostName;
    private String hostAddress;

    LocalHostModel() {
        final String NONE = "none";
        try {
            this.hostName = InetAddress.getLocalHost().getHostName();
            this.canonicalHostName = InetAddress.getLocalHost().getCanonicalHostName();
            this.hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            this.hostName = NONE;
            this.canonicalHostName = NONE;
            this.hostAddress = NONE;
        }
    }
}
