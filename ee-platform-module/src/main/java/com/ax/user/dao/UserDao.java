package com.ax.user.dao;

import com.ax.common.repository.BaseDao;
import com.ax.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by kyy on 2017/9/7.
 */
public interface UserDao extends BaseDao<User> {

    User findByName(String name);
    
}
