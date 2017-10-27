package com.ax.system.user.service;

import com.ax.BaseTest;
import com.ax.system.user.vo.MenuTree;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kyy on 2017/10/26.
 */
public class MenuServiceTest extends BaseTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void getMenuTreeByUserId() throws Exception {
        List<MenuTree> menuTreeByUserId = menuService.getMenuTree(1);
        assertEquals(2, menuTreeByUserId.size());

        List<MenuTree> menuTreeByUserId1 = menuService.getMenuTree(2);
        assertEquals(1, menuTreeByUserId1.size());
    }

}