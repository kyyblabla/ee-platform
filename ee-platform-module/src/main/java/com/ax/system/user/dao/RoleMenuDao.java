package com.ax.system.user.dao;

import com.ax.common.annotation.JpaDao;
import com.ax.common.repository.BaseDao;

import com.ax.system.user.entity.RoleMenu;

import java.util.List;

/**
 * Created by AxCodeGen on 2017/10/27.
 */
@JpaDao
public interface RoleMenuDao extends BaseDao<RoleMenu> {

    List<RoleMenu> findByRoleIdIn(List<Long> roleIds);

}