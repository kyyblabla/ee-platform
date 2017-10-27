package com.ax.system.user.dao;

import com.ax.common.annotation.JpaDao;
import com.ax.common.repository.BaseDao;

import com.ax.system.user.entity.UserRole;

import java.util.List;

/**
 * Created by AxCodeGen on 2017/10/27.
 */
@JpaDao
public interface UserRoleDao extends BaseDao<UserRole> {

    List<UserRole> findByUserId(Long userId);

}