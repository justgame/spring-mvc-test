package com.github.justgame.springmvctest.controller;

import com.github.justgame.springmvctest.entity.User;
import com.github.justgame.springmvctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xcl
 * @date 2019/11/22
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @DeleteMapping("/batch/{ids}")
    public void deleteBatch(@PathVariable List<Long> ids) {
        userService.deleteUserBatch(ids);
    }

    @PostMapping("/deleteByName")
    public void deleteByName(String name) {
        userService.deleteUserByName(name);
    }
}
