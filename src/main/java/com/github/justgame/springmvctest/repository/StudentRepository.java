package com.github.justgame.springmvctest.repository;

import com.github.justgame.springmvctest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XieCl
 * @date 2020/2/6 1:17
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
