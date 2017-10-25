package com.ax.system.user.dao;

import com.ax.common.annotation.JpaDao;
import com.ax.common.repository.BaseDao;

import com.ax.system.user.entity.User;

/**
 * Created by AxCodeGen on 2017/10/25.
 */
@JpaDao
public interface UserDao extends BaseDao<User> {

    User findByUserName(String userName);

}