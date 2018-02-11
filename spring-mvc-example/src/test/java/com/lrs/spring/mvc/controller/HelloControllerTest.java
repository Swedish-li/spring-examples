package com.lrs.spring.mvc.controller;

import com.lrs.spring.mvc.WebInitializer;
import com.lrs.spring.mvc.config.MvcConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import javax.annotation.Resource;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MvcConfig.class)
@WebAppConfiguration
public class HelloControllerTest {

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void world() throws Exception {
        mockMvc.perform(get("/hello/world"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void jsonResponse() throws Exception {
        mockMvc.perform(get("/hello/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(log())
                .andExpect(jsonPath("$.name").value("Swedish-li"))
                .andExpect(jsonPath("$.msg").value(containsString("msg")))
                .andReturn();
    }
}