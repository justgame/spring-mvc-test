package com.github.justgame.springmvctest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author XieCl
 * @date 2019/8/31 0:35
 */
@Data
@Accessors(chain = true)
public class Course {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @JsonIgnore
    private String img;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Instructor instructor;
}
