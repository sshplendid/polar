package me.shawn.polar.mono.ping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("local")
@SpringBootTest
class PingControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    void ping() throws Exception {
        mockMvc.perform(get("/ping"))
                .andDo(print())
                .andExpect(jsonPath("$.hostName").isString())
                .andExpect(jsonPath("$.canonicalHostName").isString())
                .andExpect(jsonPath("$.hostAddress").isString())
                .andExpect(status().isOk());
    }

    @Test
    void checkProfile() throws Exception {
        mockMvc.perform(get("/ping/profile"))
                .andDo(print())
                .andExpect(content().string(String.format("Profile of this application: '%s'", "local")))
                .andExpect(status().isOk());
    }
}