package com.ax.system.user.service;

import com.ax.common.service.BaseService;
import com.ax.common.util.BeanMapper;
import com.ax.system.user.dao.UserDao;
import com.ax.system.user.dto.UserDto;
import com.ax.system.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kyy on 2017/9/8.
 */
@Service
public class UserService extends BaseService<User, UserDao> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUserName(String name) {
        return dao.findByName(name);
    }

    @Transactional
    public User crateUser(UserDto userDto) {
        User user = BeanMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.save(user);
    }

    public void findByExample(){
    }

}
