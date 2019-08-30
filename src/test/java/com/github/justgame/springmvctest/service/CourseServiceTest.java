package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author XieCl
 * @date 2019/8/31 0:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void testSaveCourse() {
        saveCourse();
    }

    private void saveCourse() {
        Course course = new Course();
        course.setId(1L).setName("hello").setImg("http://example.com");
        courseService.saveCourse(course);
    }

    @Test
    public void testGetCourse() {
        saveCourse();
        Course course = courseService.getCourse(1L);
        assertNotNull(course);
    }
}
