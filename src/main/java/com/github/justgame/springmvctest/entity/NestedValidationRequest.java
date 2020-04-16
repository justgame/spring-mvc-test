package com.github.justgame.springmvctest.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class NestedValidationRequest {
    @NotNull(message = "id不能为空")
    private Long id;

    @NotEmpty(message = "name不能为空")
    private String name;

    @NotBlank(message = "message不能为空")
    private String message;

    @NotNull
    @Size(min = 2, message = "items最少要2个")
    private List<String> items;

    @Valid
    @NotNull
    private SubRequest subRequest;

    @Data
    static class SubRequest{
        @NotNull(message = "sub id不能为空")
        private Long id;

        @NotEmpty(message = "sub name不能为空")
        private String name;
    }
}
