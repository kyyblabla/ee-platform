package com.ax.system.user.controller;


import com.ax.system.user.entity.UserOrgRel;
import com.ax.system.user.dao.UserOrgRelDao;
import com.ax.system.user.service.UserOrgRelService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@RequestMapping("/UserOrgRel")
@RestController
public class UserOrgRelController extends BaseController {

    @Autowired
    private UserOrgRelService userOrgRelDao;

    @Autowired
    private UserOrgRelService userOrgRelService;

}
