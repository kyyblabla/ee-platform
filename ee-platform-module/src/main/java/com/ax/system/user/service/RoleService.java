package com.ax.system.user.service;

import com.ax.common.service.BaseService;

import com.ax.system.user.dao.RoleDao;
import com.ax.system.user.dao.UserOrgRelDao;
import com.ax.system.user.entity.Role;

import com.ax.system.user.entity.UserOrgRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@Service
public class RoleService extends BaseService<Role, RoleDao> {

    @Autowired
    private UserOrgRelDao userOrgRelDao;
    @Autowired
    private RoleUnitRelService roleUnitRelService;

    public List<Role> getUserRoles(Long userId) {
        userOrgRelDao.findByUserId(userId).stream()
                .map(UserOrgRel::getOrgId)
                .map(roleUnitRelService::getRoleRelByOrgId)
                .collect(Collectors.toList());
        roleUnitRelService.getRoleRelByUserId(userId);
        return null;
    }

}