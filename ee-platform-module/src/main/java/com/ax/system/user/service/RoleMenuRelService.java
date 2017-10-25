package com.ax.system.user.service;

import com.ax.common.service.BaseService;

import com.ax.system.user.dao.RoleMenuRelDao;
import com.ax.system.user.entity.RoleMenuRel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@Service
public class RoleMenuRelService extends BaseService<RoleMenuRel, RoleMenuRelDao> {

    @Autowired
    public void getRoles() {

    }

}