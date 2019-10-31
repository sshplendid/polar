package me.shawn.polar.core.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Configuration
public class H2ServerConfig {

    /**
     * H2 인메모리
     * @return 애플리케이션 외부에서 접근할 수 있는 H2 서버 인스턴스
     * @throws SQLException 서버가 구동에 실패하는 경우 발생
     */
    @Profile("inmemorydb")
    @Bean
    public Server h2TcpServer() throws SQLException {
        return Server.createTcpServer().start();
    }
}
