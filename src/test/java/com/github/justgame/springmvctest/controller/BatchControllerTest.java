package com.github.justgame.springmvctest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author xcl
 * @date 2019/9/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchControllerTest {
    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(BatchController.class).build();
    }

    @Test
    public void testTags() throws Exception {
        List<Long> tags = Arrays.asList(1L, 2L, 3L, 4L);
        ObjectMapper mapper = new ObjectMapper();

        mockMvc
            .perform(get("/batch/tags?tags=1,2,3,4"))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(tags)));
    }

    @Test
    public void testTags2() throws Exception {
        List<Long> tags = Arrays.asList(1L, 2L, 3L, 4L);
        ObjectMapper mapper = new ObjectMapper();

        mockMvc
            .perform(get("/batch/tags2/1,2,3,4"))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(tags)));
    }
}
