package com.example.ipinfoweather.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void main() throws Exception {
        mockMvc.perform(get("/main"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("index.html"));
    }

    @Test
    public void search() throws Exception {
        mockMvc.perform(get("/seoul"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("index.html"));
    }

    @Test
    public void search_NOT_FOUND() throws Exception {
        mockMvc.perform(get("/seoul11"))
                .andExpect(status().is3xxRedirection())
                .andDo(print())
                .andExpect(view().name("redirect:/error"));
    }

}