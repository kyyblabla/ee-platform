package com.ax.system.user.service;

import com.ax.common.service.BaseService;

import com.ax.common.tool.util.BeanMapper;
import com.ax.common.tool.util.StreamUtil;
import com.ax.common.util.TreeNodeUtil;
import com.ax.system.user.constant.UserConstant;
import com.ax.system.user.dao.MenuDao;
import com.ax.system.user.dao.RoleMenuDao;
import com.ax.system.user.entity.Menu;

import com.ax.system.user.entity.Role;
import com.ax.system.user.entity.RoleMenu;
import com.ax.system.user.util.RoleUtil;
import com.ax.system.user.vo.MenuTree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Created by AxCodeGen on 2017/10/27.
 */
@Service
public class MenuService extends BaseService<Menu, MenuDao> {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuDao roleMenuDao;

    /**
     * 获取角色的菜单树
     * 管理员会获取所有菜单
     *
     * @param userId
     * @return
     */
    public List<MenuTree> getMenuTree(long userId) {
        //获取用户角色
        List<Role> roles = roleService.getAllByUserId(userId);
        //如果是管理员获取所有菜单
        List<Menu> menuList;
        if (RoleUtil.isAdmin(roles)) {
            menuList = dao.findAll();
        } else {
            //获取角色关联的菜单
            List<Long> menuIds = StreamUtil.mapToList(roleMenuDao.findByRoleIdIn(StreamUtil.mapToList(roles, Role::getId)), RoleMenu::getMenuId);
            menuList = dao.findAll(menuIds);
        }
        return buildMenuTree(menuList);
    }


    public List<MenuTree> buildMenuTree(List<Menu> menuList) {
        List<MenuTree> treeNodeList = BeanMapper.mapList(menuList, MenuTree.class);
        return TreeNodeUtil.build(-1L, treeNodeList);
    }


}