package me.shawn.polar.mono.v1.ping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
                .andExpect(header().string("Content-Type", "application/json"))
                .andExpect(jsonPath("$.data.hostName").isString())
                .andExpect(jsonPath("$.data.canonicalHostName").isString())
                .andExpect(jsonPath("$.data.hostAddress").isString())
                .andExpect(status().isOk());
    }

    @Test
    void checkProfile() throws Exception {
        mockMvc.perform(get("/ping/profile"))
                .andDo(print())
                .andExpect(jsonPath("$.data").value(String.format("Profile of this application: '%s'", "local")))
//                .andExpect(header().string("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

}