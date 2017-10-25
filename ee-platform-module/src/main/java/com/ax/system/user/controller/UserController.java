package com.ax.system.user.controller;


import com.ax.system.user.entity.User;
import com.ax.system.user.dao.UserDao;
import com.ax.system.user.service.UserService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@RequestMapping("/User")
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userDao;

    @Autowired
    private UserService userService;

}
