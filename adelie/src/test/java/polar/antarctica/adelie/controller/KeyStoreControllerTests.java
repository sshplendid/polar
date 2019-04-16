package polar.antarctica.adelie.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeyStoreControllerTests {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .build();
    }

    @Test
    public void redisSetTest() throws Exception {
        this.mockMvc.perform(post("/keys")
                .param("key", "ping")
                .param("value", "ok"))
                .andExpect(status().isOk())
                .andDo(print());

        this.mockMvc.perform(get("/keys/ping"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("OK"))
                ;
    }

    @Test
    public void redisCRUDTest() throws Exception {
        this.mockMvc.perform(get("/keys/value"))
                .andExpect(status().isOk());
    }
}
