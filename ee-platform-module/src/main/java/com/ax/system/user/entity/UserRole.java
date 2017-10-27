package com.ax.system.user.entity;

import java.time.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

/**
 * 
 * Created by AxCodeGen on 2017/10/27.
 */
@Entity
@Table(name="sys_user_role")
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;
    private Long roleId;
    private Long userId;
    private Long createBy;
    private LocalDateTime createTime;

    public UserRole() {}

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

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        return "UserRole ("+
                "id=" + id + ", " +
                "roleId=" + roleId + ", " +
                "userId=" + userId + ", " +
                "createBy=" + createBy + ", " +
                "createTime=" + createTime +")";
    }
}