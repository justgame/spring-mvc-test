package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

/**
 * @author XieCl
 * @date 2019/8/31 0:38
 */
@Service
public class CourseService {
    @Autowired
    private Cache cache;

    public void saveCourse(Course course) {
        System.out.println("save course: " + course);
        cache.put("course:" + course.getId(), course);
    }

    public Course getCourse(Long id) {
        Course course = cache.get("course:" + id, Course.class);
        System.out.println("get course: " + course);
        return course;
    }
}
