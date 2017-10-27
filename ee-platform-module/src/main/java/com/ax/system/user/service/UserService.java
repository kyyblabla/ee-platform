package com.ax.system.user.service;

import com.ax.common.service.BaseService;

import com.ax.system.user.dao.UserDao;
import com.ax.system.user.entity.User;

import org.springframework.stereotype.Service;


/**
 * Created by AxCodeGen on 2017/10/27.
 */
@Service
public class UserService extends BaseService<User, UserDao> {


    public User findByUserName(String username) {

        return dao.findByUserName(username);
    }
}