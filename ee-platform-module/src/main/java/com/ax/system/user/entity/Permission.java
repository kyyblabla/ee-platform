package com.ax.system.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.*;

/**
 * 
 * Table Name: permission
 * Created by AxCodeGen on 2017/10/25.
 */
@Entity
public class Permission {

    @Id
    private Long id;
    private String roleCode;
    private String roleName;
    private String roleDesc;
    private Integer orderNum;
    private Long createBy;
    private Long modifyBy;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    public Permission() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return this.roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getModifyBy() {
        return this.modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }


    @Override
    public String toString() {
        return "Permission"+
        "id=" + id + ", " +
        "roleCode=" + roleCode + ", " +
        "roleName=" + roleName + ", " +
        "roleDesc=" + roleDesc + ", " +
        "orderNum=" + orderNum + ", " +
        "createBy=" + createBy + ", " +
        "modifyBy=" + modifyBy + ", " +
        "createTime=" + createTime + ", " +
        "modifyTime=" + modifyTime +")";
    }
}