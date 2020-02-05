package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.Student;
import com.github.justgame.springmvctest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XieCl
 * @date 2020/2/6 1:18
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student get(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
