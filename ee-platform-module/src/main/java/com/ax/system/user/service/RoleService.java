package com.ax.system.user.service;

import com.ax.common.service.BaseService;

import com.ax.system.user.dao.RoleDao;
import com.ax.system.user.dao.UserOrgRelDao;
import com.ax.system.user.entity.Role;

import com.ax.system.user.entity.RoleUnitRel;
import com.ax.system.user.entity.UserOrgRel;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author AxCodeGen
 * @date 2017/10/25
 */
@Service
public class RoleService extends BaseService<Role, RoleDao> {

    @Autowired
    private UserOrgRelDao userOrgRelDao;
    @Autowired
    private RoleUnitRelService roleUnitRelService;

    //TODO 加入缓存
    public List<Role> getUserRoles(long userId) {
        List<Role> roles = dao.findAll(getRoleIdList(userId));
        return roles;
    }

    private List<Long> getRoleIdList(long userId) {
        //获取用户的直接角色
        List<RoleUnitRel> userRoles = roleUnitRelService.getRoleRelByUserId(userId);
        //获取用户组织关联的角色
        List<RoleUnitRel> orgRoles = userOrgRelDao.findByUserId(userId)
                .stream()
                .map(UserOrgRel::getOrgId)
                .map(roleUnitRelService::getRoleRelByOrgId)
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        userRoles.addAll(orgRoles);
        return userRoles.stream()
                .map(RoleUnitRel::getRoleId)
                .distinct()
                .collect(Collectors.toList());
    }

}