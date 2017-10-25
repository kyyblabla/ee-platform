package com.ax.system.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.*;

/**
 * 
 * Table Name: role_menu_rel
 * Created by AxCodeGen on 2017/10/25.
 */
@Entity
public class RoleMenuRel {

    @Id
    private Long id;
    private Long roleId;
    private Long menuId;
    private Long createBy;
    private LocalDateTime createTime;

    public RoleMenuRel() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "RoleMenuRel"+
        "id=" + id + ", " +
        "roleId=" + roleId + ", " +
        "menuId=" + menuId + ", " +
        "createBy=" + createBy + ", " +
        "createTime=" + createTime +")";
    }
}