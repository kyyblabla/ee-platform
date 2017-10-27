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
@Table(name="sys_role_org")
public class RoleOrg {

    @Id
    @GeneratedValue
    private Long id;
    private Long roleId;
    private Long orgId;
    private Long createBy;
    private LocalDateTime createTime;

    public RoleOrg() {}

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

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
        return "RoleOrg ("+
                "id=" + id + ", " +
                "roleId=" + roleId + ", " +
                "orgId=" + orgId + ", " +
                "createBy=" + createBy + ", " +
                "createTime=" + createTime +")";
    }
}