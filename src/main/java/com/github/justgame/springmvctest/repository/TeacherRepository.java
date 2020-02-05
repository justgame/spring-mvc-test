package com.github.justgame.springmvctest.repository;

import com.github.justgame.springmvctest.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XieCl
 * @date 2020/2/6 1:29
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
