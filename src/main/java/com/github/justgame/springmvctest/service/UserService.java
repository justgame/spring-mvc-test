package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.User;
import com.github.justgame.springmvctest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XieCl
 * @date 2019/10/8 22:34
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
