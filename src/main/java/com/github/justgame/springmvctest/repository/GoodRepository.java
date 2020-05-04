package com.github.justgame.springmvctest.repository;

import com.github.justgame.springmvctest.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XieCl
 * @date 2020/5/5 2:00
 */
public interface GoodRepository extends JpaRepository<Good, Long> {
}
