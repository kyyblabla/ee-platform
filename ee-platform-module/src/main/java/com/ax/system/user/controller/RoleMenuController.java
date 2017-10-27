package com.ax.system.user.controller;


import com.ax.system.user.entity.RoleMenu;
import com.ax.system.user.dao.RoleMenuDao;
import com.ax.system.user.service.RoleMenuService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/27.
 */
@RequestMapping("/roleMenu")
@RestController
public class RoleMenuController extends BaseController {

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private RoleMenuService roleMenuService;

}
