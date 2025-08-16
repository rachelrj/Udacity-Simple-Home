package org.example.simplehome;

import org.example.simplehome.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void firstVisit_true_then_firstVisit_false() throws Exception {
        MockHttpSession session = new MockHttpSession();

        // 1st request — first visit
        mockMvc.perform(get("/home").session(session))
                .andExpect(status().isOk())
                .andExpect(model().attribute("firstVisit", true));

        // 2nd request — not first visit anymore
        mockMvc.perform(get("/home").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("firstVisit", false));
    }
}
