package com.ax.system.user.controller;


import com.ax.system.user.entity.Organization;
import com.ax.system.user.dao.OrganizationDao;
import com.ax.system.user.service.OrganizationService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/27.
 */
@RequestMapping("/organization")
@RestController
public class OrganizationController extends BaseController {

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private OrganizationService organizationService;

}
