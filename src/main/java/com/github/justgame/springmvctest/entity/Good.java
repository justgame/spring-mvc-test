package com.github.justgame.springmvctest.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * @author XieCl
 * @date 2020/5/5 1:57
 */
@Data
@Accessors(chain = true)
@Entity
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    private Date createAt;

    private Date updateAt;

    @PrePersist
    void prePersist() {
        createAt = new Date();
        updateAt = createAt;
    }

    @PreUpdate
    void preUpdate() {
        updateAt = new Date();
    }
}
