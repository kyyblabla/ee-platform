package com.ax.system.user.controller;


import com.ax.system.user.entity.RoleUnitRel;
import com.ax.system.user.dao.RoleUnitRelDao;
import com.ax.system.user.service.RoleUnitRelService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@RequestMapping("/RoleUnitRel")
@RestController
public class RoleUnitRelController extends BaseController {

    @Autowired
    private RoleUnitRelService roleUnitRelDao;

    @Autowired
    private RoleUnitRelService roleUnitRelService;

}
