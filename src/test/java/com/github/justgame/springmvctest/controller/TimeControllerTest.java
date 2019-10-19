package com.github.justgame.springmvctest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.justgame.springmvctest.entity.TimeVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author XieCl
 * @date 2019/10/19 14:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeControllerTest {
    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(TimeController.class).build();
    }

    @Test
    public void testSaveTime() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TimeVo time = new TimeVo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        time.setStartTime(sdf.parse("2019-02-19 00:00:00"));
        time.setEndTime((sdf.parse("2019-08-16 23:59:59")));
        String json = mapper.writeValueAsString(time);
        System.out.println(json);

        mockMvc
            .perform(
                post("/time")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(json))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(json));
    }
}
