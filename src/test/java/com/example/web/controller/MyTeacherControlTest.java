package com.example.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.web.dto.StudentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class MyTeacherControlIntTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void addStudent() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new StudentDto("roo", "foo")));

        var expected = new StudentDto("max", "foo");

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
                .andReturn();
    }

    @Test
    void getHomework() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/viewhomework");
        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());
    }
}