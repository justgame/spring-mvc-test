package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.entity.Course;
import com.github.justgame.springmvctest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author XieCl
 * @date 2019/8/31 0:37
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/courses")
    public void saveCourse(@RequestBody @Valid Course course) {
        courseService.saveCourse(course);
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }
}
