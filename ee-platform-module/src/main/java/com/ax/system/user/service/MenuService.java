package com.ax.system.user.service;

import com.ax.common.service.BaseService;
import com.ax.common.tool.util.BeanMapper;
import com.ax.common.util.TreeNodeUtil;
import com.ax.system.user.dao.MenuDao;
import com.ax.system.user.dao.RoleMenuRelDao;
import com.ax.system.user.dto.MenuDto;
import com.ax.system.user.entity.Menu;
import com.ax.system.user.entity.Role;
import com.ax.system.user.entity.RoleMenuRel;
import com.ax.system.user.util.RoleUtil;
import com.ax.system.user.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@Service
public class MenuService extends BaseService<Menu, MenuDao> {


    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenuRelDao roleMenuRelDao;


    @Transactional
    public Menu saveMenu(MenuDto menuDto) {
        Menu menu = BeanMapper.map(menuDto, Menu.class);
        return dao.save(menu);
    }

    @Transactional
    public void deleteMenu(long id) {
        //如果有子菜单，递归删除
        dao.findByParentId(id)
                .forEach(subMenu -> deleteMenu(subMenu.getId()));
        //删除角色关联的菜单
        roleMenuRelDao.delete(id);
        //删除
        dao.delete(id);
    }

    /**
     * 获取用户菜单树
     * 管理员获取所有菜单，其他用户根据角色获取
     *
     * @param userId
     * @return
     */
    public List<MenuTree> getMenuTreeByUserId(int userId) {
        List<Role> roles = roleService.getUserRoles(userId);
        if (isAdmin(roles)) {
            return getMenuTree();
        } else {
            List<Long> roleIds = roles.stream()
                    .map(Role::getId)
                    .collect(Collectors.toList());
            List<Long> menuIds = roleMenuRelDao.findByRoleIdIn(roleIds)
                    .stream()
                    .map(RoleMenuRel::getMenuId)
                    .collect(Collectors.toList());
            return buildMenuTree(dao.findAll(menuIds));
        }
    }

    /**
     * 获取完整菜单树
     *
     * @return
     */
    public List<MenuTree> getMenuTree() {
        return buildMenuTree(dao.findAll());
    }

    private List<MenuTree> buildMenuTree(List<Menu> menus) {
        List<MenuTree> collect = menus.stream()
                .map(menu -> BeanMapper.map(menu, MenuTree.class))
                .collect(Collectors.toList());
        return TreeNodeUtil.build(-1L, collect);
    }

    private boolean isAdmin(List<Role> userRoles) {
        return userRoles.stream()
                .filter(RoleUtil::isAdmin)
                .findFirst().isPresent();
    }

}