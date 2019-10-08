package com.github.justgame.springmvctest.repository;

import com.github.justgame.springmvctest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XieCl
 * @date 2019/10/8 22:34
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
