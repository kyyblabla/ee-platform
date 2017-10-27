package com.ax.system.user.controller;


import com.ax.system.user.entity.RoleOrg;
import com.ax.system.user.dao.RoleOrgDao;
import com.ax.system.user.service.RoleOrgService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/27.
 */
@RequestMapping("/roleOrg")
@RestController
public class RoleOrgController extends BaseController {

    @Autowired
    private RoleOrgDao roleOrgDao;

    @Autowired
    private RoleOrgService roleOrgService;

}
