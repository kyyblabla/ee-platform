package com.ax.system.user.dao;

import com.ax.common.annotation.JpaDao;
import com.ax.common.repository.BaseDao;

import com.ax.system.user.entity.Menu;
import com.ax.system.user.entity.RoleMenuRel;

import java.util.List;

/**
 * Created by AxCodeGen on 2017/10/25.
 */
@JpaDao
public interface RoleMenuRelDao extends BaseDao<RoleMenuRel> {

    List<RoleMenuRel> findByRoleIdIn(List<Long> roleIds);

    long deleteByMenuId(long menuId);

}