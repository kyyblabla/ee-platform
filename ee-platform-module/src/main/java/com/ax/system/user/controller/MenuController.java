package com.ax.system.user.controller;


import com.ax.system.user.entity.Menu;
import com.ax.system.user.dao.MenuDao;
import com.ax.system.user.service.MenuService;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@RequestMapping("/Menu")
@RestController
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuDao;

    @Autowired
    private MenuService menuService;

}
