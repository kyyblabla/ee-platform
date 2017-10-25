package com.ax.system.user.controller;


import com.ax.system.user.entity.RoleMenuRel;
import com.ax.system.user.dao.RoleMenuRelDao;
import com.ax.system.user.service.RoleMenuRelService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@RequestMapping("/RoleMenuRel")
@RestController
public class RoleMenuRelController extends BaseController {

    @Autowired
    private RoleMenuRelService roleMenuRelDao;

    @Autowired
    private RoleMenuRelService roleMenuRelService;

}
