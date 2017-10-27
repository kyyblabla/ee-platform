package com.ax.system.user.controller;


import com.ax.system.user.entity.UserRole;
import com.ax.system.user.dao.UserRoleDao;
import com.ax.system.user.service.UserRoleService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/27.
 */
@RequestMapping("/userRole")
@RestController
public class UserRoleController extends BaseController {

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private UserRoleService userRoleService;

}
