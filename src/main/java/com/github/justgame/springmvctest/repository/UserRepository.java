package com.github.justgame.springmvctest.repository;

import com.github.justgame.springmvctest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * @author XieCl
 * @date 2019/10/8 22:34
 */
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByIdIn(Collection<Long> ids);

    void deleteByNameContaining(String name);
}
