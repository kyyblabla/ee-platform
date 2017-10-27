package com.ax.system.user.service;

import com.ax.common.service.BaseService;

import com.ax.system.user.dao.RoleDao;
import com.ax.system.user.dao.UserRoleDao;
import com.ax.system.user.entity.Role;

import com.ax.system.user.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by AxCodeGen on 2017/10/27.
 */
@Service
public class RoleService extends BaseService<Role, RoleDao> {

    @Autowired
    private UserRoleDao userRoleDao;

    /**
     * 获取用户所有角色
     *
     * @param userId
     * @return
     */
    public List<Role> getAllByUserId(long userId) {
        return dao.findAll(userRoleDao.findByUserId(userId)
                .stream()
                .map(UserRole::getUserId)
                .distinct()
                .collect(Collectors.toList()));
    }

}