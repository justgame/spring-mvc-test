package com.github.justgame.springmvctest.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author XieCl
 * @date 2020/4/25 20:59
 */
@Data
public class CommonValidationRequest {
    @NotEmpty
    private String str1;

    @Size(min = 5)
    private String str2;

    @NotEmpty
    private List<String> list1;

    @Size(min = 2)
    private List<String> list;
}
