package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XieCl
 * @date 2020/2/6 1:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void testGet() {
        Long id = 1L;
        Teacher teacher = teacherService.get(id);
        Assert.assertNotNull(teacher);
        Assert.assertEquals(2, teacher.getStudents().size());
    }
}
