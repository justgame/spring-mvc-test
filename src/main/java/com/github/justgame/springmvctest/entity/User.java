package com.github.justgame.springmvctest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.Date;

/**
 * @author XieCl
 * @date 2019/10/8 22:28
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private Date createAt;

    @PrePersist
    void createAt() {
        createAt = new Date();
    }
}
