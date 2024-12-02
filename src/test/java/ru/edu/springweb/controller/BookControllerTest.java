package ru.edu.springweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import ru.edu.springweb.domain.entity.Book;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebApplicationConfig.class)
class BookControllerTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                .content(objectMapper.writeValueAsString(new Book("Book1", "Ivanov")))
                .contentType("application/json")
                .accept("application/json"));
        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                .content(objectMapper.writeValueAsString(new Book("Book2", "Petrov")))
                .contentType("application/json")
                .accept("application/json"));
        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                .content(objectMapper.writeValueAsString(new Book("Book3", "Sidorov")))
                .contentType("application/json")
                .accept("application/json"));
    }

    @Test
    void save() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .content(objectMapper.writeValueAsString(new Book("Book4", "Smirnov")))
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/1")
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/book/3")
                        .content(objectMapper.writeValueAsString(new Book("Test", "Smirnov")))
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/book/2")
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/books")
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}