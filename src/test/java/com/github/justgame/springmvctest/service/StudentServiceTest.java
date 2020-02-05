package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XieCl
 * @date 2020/2/6 1:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testGet() {
        Long id = 1L;
        Student student = studentService.get(id);
        Assert.assertNotNull(student);
        Assert.assertEquals("zx", student.getName());
    }
}
