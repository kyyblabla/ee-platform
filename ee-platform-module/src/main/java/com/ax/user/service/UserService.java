package com.ax.user.service;

import com.ax.common.util.BeanMapper;
import com.ax.user.dao.UserDao;
import com.ax.user.dto.UserDto;
import com.ax.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kyy on 2017/9/8.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUserName(String name) {
        return userDao.findByName(name);
    }

    @Transactional
    public User crateUser(UserDto userDto) {
        User user = BeanMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return user;
    }

}