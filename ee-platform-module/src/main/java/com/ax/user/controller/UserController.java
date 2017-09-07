package com.ax.user.controller;

import com.ax.user.dao.UserDao;
import com.ax.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/9/6.
 */
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping
    public User findByName(@RequestParam("name") String name) {
        return userDao.findByName(name);
    }

}
