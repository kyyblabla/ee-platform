package com.ax.system.user.controller;


import com.ax.system.user.entity.Role;
import com.ax.system.user.dao.RoleDao;
import com.ax.system.user.service.RoleService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/27.
 */
@RequestMapping("/role")
@RestController
public class RoleController extends BaseController {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleService roleService;

}
