package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.Teacher;
import com.github.justgame.springmvctest.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XieCl
 * @date 2020/2/6 1:30
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher get(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }
}