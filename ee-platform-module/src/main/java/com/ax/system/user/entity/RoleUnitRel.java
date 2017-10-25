package com.ax.system.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.*;

/**
 * Table Name: role_unit_rel
 * Created by AxCodeGen on 2017/10/25.
 */
@Entity
public class RoleUnitRel {

    @Id
    private Long id;
    private Long roleId;
    private Long unitId;
    private String unitType;
    private Long createBy;
    private LocalDateTime createTime;

    public RoleUnitRel() {
    }

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

    public Long getUnitId() {
        return this.unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnitType() {
        return this.unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
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
        return "RoleUnitRel" +
                "id=" + id + ", " +
                "roleId=" + roleId + ", " +
                "unitId=" + unitId + ", " +
                "unitType=" + unitType + ", " +
                "createBy=" + createBy + ", " +
                "createTime=" + createTime + ")";
    }
}