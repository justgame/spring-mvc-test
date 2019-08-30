package com.github.justgame.springmvctest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author XieCl
 * @date 2019/8/31 0:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testSaveCourse() throws Exception {
        mockMvc
            .perform(
                post("/courses")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content("{\"id\": 1, \"name\": \"good\", \"img\": \"http://xixixi.org\"}"))
            .andExpect(status().isOk());

        mockMvc.perform(
            get("/courses/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json("{\"id\": 1, \"name\": \"good\"}"));
    }
}