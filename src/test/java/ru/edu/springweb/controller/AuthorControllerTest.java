package ru.edu.springweb.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.edu.springweb.config.WebApplicationConfig;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebApplicationConfig.class)
class AuthorControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void author() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/author").contentType("text/html"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void authorHobbies() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hobbies").contentType("text/html"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}