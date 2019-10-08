package com.github.justgame.springmvctest.service;

import com.github.justgame.springmvctest.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author XieCl
 * @date 2019/10/8 22:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSaveAndGetUser() {
        User user = new User();
        user.setName("test");
        user.setAge(17);

        User user1 = userService.save(user);
        User user2 = userService.getUser(user1.getId());
        assertEquals(user.getName(), user2.getName());
        assertEquals(user.getAge(), user2.getAge());
    }
}