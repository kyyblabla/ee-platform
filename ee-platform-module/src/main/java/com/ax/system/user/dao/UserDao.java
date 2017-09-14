package com.ax.system.user.dao;

import com.ax.common.annotation.JpaDao;
import com.ax.common.repository.BaseDao;
import com.ax.system.user.entity.User;

/**
 * Created by kyy on 2017/9/7.
 */
@JpaDao
public interface UserDao extends BaseDao<User> {

    User findByName(String name);
    
}
