package com.ax.system.user.controller;


import com.ax.system.user.entity.Permission;
import com.ax.system.user.dao.PermissionDao;
import com.ax.system.user.service.PermissionService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@RequestMapping("/Permission")
@RestController
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionDao;

    @Autowired
    private PermissionService permissionService;

}
